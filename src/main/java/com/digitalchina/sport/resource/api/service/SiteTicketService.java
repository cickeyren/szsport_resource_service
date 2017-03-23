package com.digitalchina.sport.resource.api.service;

import com.digitalchina.common.utils.DateUtil;
import com.digitalchina.sport.resource.api.controller.SiteTicketController;
import com.digitalchina.sport.resource.api.dao.SiteTicketDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author:wangw
 * @Description:场地票管理
 * @Date:Created on 2017/3/16.
 */
@Service
public class SiteTicketService {
    private static final Logger logger = LoggerFactory.getLogger(SiteTicketService.class);

    @Autowired
    private SiteTicketDao siteTicketDao;

    /**
     * 根据场馆获取生效的场地票列表信息
     * @param map
     * @return
     */
    public List<Map<String, Object>> getValidSiteTicketList(Map<String, Object> map){
        return siteTicketDao.getValidSiteTicketList(map);
    }

    /**
     * 根据场地票获取场地列表信息
     * @param map
     * @return
     */
    public List<Map<String, Object>> getFieldListByTicket(Map<String, Object> map){
        List<Map<String, Object>> fieldIdList = siteTicketDao.getFieldListByTicket(map);
        List<String> itemList = new ArrayList<String>();
        for (int i = 0; i < fieldIdList.size(); i++){
            String[] itemArr = fieldIdList.get(i).get("site").toString().split(",");
            for(int j = 0; j < itemArr.length; j++){
                boolean isExist = false;
                for (int k = 0; k < itemList.size(); k++){
                    if(itemArr[j].equals(itemList.get(k))) {
                        isExist = true;
                        continue;
                    }
                }
                if(!isExist){
                    itemList.add(itemArr[j]);
                }
            }
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ids", itemList);
        return siteTicketDao.getFieldListByIds(paramMap);
    }

    /**
     * 根据场地票获取场地开放时段
     * @param map
     * @return
     */
    public List<Map<String, Object>> getTimeIntervalByTicket(Map<String, Object> map){
        return siteTicketDao.getTimeIntervalByTicket(map);
    }

    /**
     * 获取策略中场地时段内的详细信息
     * @param ticketId
     * @param searchTime
     * @return
     */
    public Map<String, Object> getSiteInfoByTicket(String ticketId, Date searchTime){
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("ticketId", ticketId);
        paramMap.put("searchTime", DateUtil.formatDate(searchTime));
        SimpleDateFormat df = new SimpleDateFormat("EEEE",Locale.CHINESE);
        String week = df.format(searchTime);
        //根据场地票获取场地列表信息
        List<Map<String, Object>> fieldList = getFieldListByTicket(paramMap);
        //根据场地票获取场地开放时段
        List<Map<String, Object>> timeIntervalList = siteTicketDao.getTimeIntervalByTicket(paramMap);
        //根据场地票获取价格策略
        List<Map<String, Object>> strategyList = siteTicketDao.getStrategyByTicket(paramMap);
        List<Map<String, Object>> priceList = new ArrayList<Map<String, Object>>();
        //获取各个场地各个时段内的价格
        for (int i = 0; i < fieldList.size(); i++){
            for (int j = 0; j < timeIntervalList.size(); j++){
                Map<String, Object> itemMap = new HashMap<String, Object>();
                itemMap.put("fieldId", fieldList.get(i).get("id"));
                itemMap.put("fieldName", fieldList.get(i).get("fieldName"));
                itemMap.put("timeIntervalId", timeIntervalList.get(j).get("id"));
                itemMap.put("timeInter", timeIntervalList.get(j).get("timeInter"));
                itemMap.put("timeSort", timeIntervalList.get(j).get("timeSort"));
                itemMap.put("timeCode", timeIntervalList.get(j).get("timeCode"));
                int status = -1;
                String price = new String();
                for (int k = 0; k < strategyList.size(); k++){
                    String dateType = strategyList.get(k).get("dateType").toString();
                    String[] sites = strategyList.get(k).get("site").toString().split(",");
                    String[] weekDetails = strategyList.get(k).get("weekDetails").toString().split(",");
                    String[] specificDate = strategyList.get(k).get("specificDate").toString().split(",");
                    String sellPrice = strategyList.get(k).get("sellPrice").toString();
                    String[] timeIntervalId = strategyList.get(k).get("timeIntervalId").toString().split(",");
                    //日期类型为周
                    if("1".equals(dateType)){
                        if(Arrays.asList(weekDetails).contains(this.weekToNum(week))){
                            if(Arrays.asList(sites).contains(fieldList.get(i).get("id"))){
                                if(Arrays.asList(timeIntervalId).contains(timeIntervalList.get(j).get("id"))){
                                    price = sellPrice;
                                    status = 0;
                                    continue;
                                }
                            }
                        }
                    }else if("3".equals(dateType)){
                        //日期类型为指定日，判断时间是否在指定日以内
                        for(int l = 0; l < specificDate.length; l++){
                            String[] specifice= specificDate[l].split("\\$");
                            Date startTime = DateUtil.parseDate(specifice[0]);
                            Date endTime = DateUtil.parseDate(specifice[1]);
                            if(searchTime.after(startTime) && searchTime.before(endTime)){
                                if(Arrays.asList(sites).contains(fieldList.get(i).get("id"))){
                                    if(Arrays.asList(timeIntervalId).contains(timeIntervalList.get(j).get("id"))){
                                        price = sellPrice;
                                        status = 0;
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }
                itemMap.put("status", status);
                itemMap.put("sellPrice", price);
                priceList.add(itemMap);
            }
        }
        //获取各个场地各个时段内的状态
        List<Map<String, Object>> stateList = siteTicketDao.getOrderFieldTime(paramMap);
        List<Map<String, Object>> sitePriceList = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < priceList.size(); i++){
            Map<String, Object> itemMap = priceList.get(i);
            for (int j = 0; j < stateList.size(); j++){
                if(priceList.get(i).get("fieldId").equals(stateList.get(j).get("fieldId"))){
                    if(priceList.get(i).get("timeIntervalId").equals(stateList.get(j).get("timeIntervalId"))){
                        itemMap.put("status", stateList.get(j).get("status"));
                    }
                }
            }
            sitePriceList.add(itemMap);
        }
        Map<String,Object> rtnMap = new HashMap<String,Object>();
        rtnMap.put("fieldList",fieldList);
        rtnMap.put("timeIntervalList",timeIntervalList);
        rtnMap.put("priceList",sitePriceList);
        return rtnMap;
    }

    /**
     * 将文字形式的星期转换成对应的数字
     * @param week
     * @return
     */
    public String weekToNum(String week){
        String num = "";
        if(week.equals("星期一")){
            num = "1";
        } else if(week.equals("星期二")){
            num = "2";
        } else if(week.equals("星期三")){
            num = "3";
        } else if(week.equals("星期四")){
            num = "4";
        } else if(week.equals("星期五")){
            num = "5";
        } else if(week.equals("星期六")){
            num = "6";
        } else if(week.equals("星期日")){
            num = "7";
        }
        return num;
    }
}
