package com.digitalchina.sport.resource.api.controller;

import com.digitalchina.common.RtnData;
import com.digitalchina.common.utils.HttpClientUtil;
import com.digitalchina.common.utils.StringUtil;
import com.digitalchina.sport.resource.api.common.config.Config;
import com.digitalchina.sport.resource.api.dao.YearStrategyDao;
import com.digitalchina.sport.resource.api.model.YearStrategyTicketModel;
import com.digitalchina.sport.resource.api.service.StadiumService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * 场馆control
 */
@RestController
@RequestMapping("/res/api/ticket/")
public class TicketController {

    public static final Logger logger = LoggerFactory.getLogger(TicketController.class);

    @Autowired
    private Config config;
    @Autowired
    private YearStrategyDao yearStrategyDao;

    /**
     * 根据根据票策略ID获取票策略详情及子场馆列表及相关验票规则
     * @param yearStrategyId
     * @return
     */
    @RequestMapping(value = "/getYearStrategyTicketModelInfo.json")
    @ResponseBody
    public RtnData getYearStrategyTicketModelInfo(@RequestParam(required = true) String yearStrategyId) {
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            Map<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("id",yearStrategyId);
            paramMap.put("strategyState","1");
            YearStrategyTicketModel ticketModel = yearStrategyDao.getYearStrategyTicketModelById(paramMap);
            resultMap.put("yearStrategyDetail",ticketModel);
            if(null !=ticketModel) {
                resultMap.put("studStadiumList",yearStrategyDao.getYearStrategyStadiumRelationsModelByYearStrategyId(yearStrategyId));
                resultMap.put("checkShieldTimeList",yearStrategyDao.getTicketStrategyCommonCheckShieldTimeModelList(yearStrategyId));
                resultMap.put("checkUseableTimeList",yearStrategyDao.getYearStrategyTicketCheckUseableTimeModelList(yearStrategyId));
            }
            return RtnData.ok(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("========根据票策略ID获取票策略详情及子场馆列表失败=========",e);
        }
        return RtnData.fail("根据票策略ID获取票策略详情及子场馆列表失败");
    }

    /**
     * 根据体育馆主主场馆ID，及分类获取年卡列表
     * @param pageIndex
     * @param pageSize
     * @param classify
     * @param mainStadiumId
     * @return
     */
    @RequestMapping(value="getYearStrategyTicketModelInfoList.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getYearStrategyTicketModelInfoList( @RequestParam(value = "pageIndex", required = false)String pageIndex,
                                                      @RequestParam(value = "pageSize", required = false) String pageSize,
                                                      @RequestParam(required = false) String mainStadiumId,
                                                      @RequestParam(required = false) String classify) {
        //调用管理端接口，集成UPMS后，不支持此种方式
        /*String url = "yearstrategyticket/api/getYearStrategyTicketModelInfoList.json?mainStadiumId="+mainStadiumId;
        if(!StringUtil.isEmpty(pageIndex)) {
            url += "&pageIndex="+pageIndex;
        }
        if(!StringUtil.isEmpty(pageSize)) {
            url += "&pageSize="+pageSize;
        }
        if(!StringUtil.isEmpty(classify)) {
            url += "&classify="+classify;
        }
        return HttpClientUtil.doGet(config.SPORT_MGR_URL + url,50000,null,"");*/
        try {
            Map<String,Object> paramMap = new HashMap<String,Object>();
            if (StringUtils.isEmpty(pageIndex)) {
                pageIndex = "0";
            }

            if(StringUtils.isEmpty(pageSize)) {
                pageSize = config.pageSize;
            }
            paramMap.put("pageIndex",Integer.valueOf(pageIndex) * Integer.valueOf(pageSize));
            paramMap.put("pageSize",Integer.valueOf(pageSize));
            paramMap.put("mainStadiumId",mainStadiumId);
            paramMap.put("classify",classify);
            paramMap.put("strategyState","1");
            Map<String,Object> resultMap = new HashMap<String,Object>();
            resultMap.put("yearStrategyList",yearStrategyDao.getYearStrategyTicketModelInfoList(paramMap));
            return RtnData.ok(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("========根分页参数获取年票策略列表失败=========",e);
        }
        return RtnData.fail("根分页参数获取年票策略列表失败");
    }

}
