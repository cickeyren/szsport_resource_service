package com.digitalchina.sport.resource.api.controller;

import com.digitalchina.common.RtnData;
import com.digitalchina.common.utils.DistanceUtils;
import com.digitalchina.common.utils.StringUtil;
import com.digitalchina.sport.resource.api.common.config.Config;
import com.digitalchina.sport.resource.api.service.StadiumService;
import com.mysql.jdbc.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 场馆control
 */
@RestController
@RequestMapping("/res/api/stadium/")
public class StadiumController {

    public static final Logger logger = LoggerFactory.getLogger(StadiumController.class);

    @Autowired
    private Config config;
    @Autowired
    private StadiumService stadiumService;

    /**
     * 获取所有精选场馆
     * @return
     */
    @RequestMapping(value="getAllSpecialStadium.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllSpecialStadium( @RequestParam(value = "clientLng", required = false) String clientLng,
                                        @RequestParam(value = "clientLat", required = false) String clientLat) {
        List<Map<Object,Object>> mapList = null;
        if(StringUtil.isEmpty(clientLat) || StringUtil.isEmpty(clientLat)) {
            try {
                mapList = stadiumService.getAllSpecialStadiumWithNoLngLat();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("获取精选场馆失败",e);
                return RtnData.ok("获取精选场馆失败");
            }
        } else {
            Map paramMap = DistanceUtils.returnLLSquarePoint(Double.parseDouble(clientLng),Double.parseDouble(clientLat),Double.parseDouble(config.defaultDistance));
            paramMap.put("clientLng",clientLng);
            paramMap.put("clientLat",clientLat);
            mapList = stadiumService.getAllSpecialStadium(paramMap);
        }

        for(int i = 0; i< mapList.size();i++) {
            Map<Object,Object> param = mapList.get(i);
            Double distance = (Double) param.get("subdetail");
            if(null != distance) {
                param.put("subdetail", String.format("%.2f",distance/1000) + " km");
            } else {
                param.put("subdetail","");
            }
            param.put("action",config.SPORT_RESOURCE_URL + "/html/arenaDetail.html?mainStadiumId=" + param.get("id"));
        }

        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("list",mapList);
        return RtnData.ok(resultMap);
    }

    /**
     * 获取所有场馆列表(根据用户当前经纬排序)
     * @return
     */
    @RequestMapping(value = "getAllStadiumList.json", method = RequestMethod.GET)
    @ResponseBody
    //用户传递来的经纬度
    public Object getAllStadiumList(@RequestParam(value = "pageIndex",defaultValue = "0", required = false) String pageIndex,
                                    @RequestParam(value = "pageSize", required = false) String pageSize,
                                    @RequestParam(value = "clientLng", required = true) String clientLng,
                                    @RequestParam(value = "clientLat", required = true) String clientLat){
        Map paramMap = DistanceUtils.returnLLSquarePoint(Double.parseDouble(clientLng),Double.parseDouble(clientLat),Double.parseDouble(config.defaultDistance));
        paramMap.put("clientLng",clientLng);
        paramMap.put("clientLat",clientLat);
        if (StringUtils.isNullOrEmpty(pageSize)){
            paramMap.put("pageSize",config.pageSize);
        }else {
            paramMap.put("pageSize",pageSize);
        }
        paramMap.put("pageIndex",pageIndex);
        List stadiumList = stadiumService.getAllStadiumList(paramMap);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("pageIndex",pageIndex);
        resultMap.put("stadiumList",stadiumList);
        resultMap.put("count",stadiumList!=null?stadiumList.size():0);
        return RtnData.ok(resultMap);

    }

    /**
     * 根据子场馆ID获得子场馆和所属父场馆详情
     * 主场馆的图片展示
     * @param stadiumId
     * @return
     */
    @RequestMapping(value="getStadiumDetail.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getStadiumDetail(@RequestParam(value = "stadiumId", required = false) String stadiumId){
        Map<String,Object> reqMap=new HashMap<String, Object>();//返回的map

        Map<String,String> stadiumDetail = stadiumService.getStadiumDetail(stadiumId);
        String mianStadiumId = stadiumDetail.get("pid");//获取该子场馆的主场馆ID
        if(mianStadiumId!=null && !"".equals(mianStadiumId)){
            List<Map<Object,Object>> picList = stadiumService.getAllPictureByStadiumId(mianStadiumId);
            reqMap.put("picList",picList);
        }

        reqMap.put("stadiumDetail",stadiumDetail);
        return RtnData.ok(reqMap);
    }

    /*
     * 根据分类获取子场馆列表
     * @RequestParam 用户经纬度，选中的分类，pageIndex，pageSize
     * @return
     */
    @RequestMapping(value = "getSubStadiumListByClassify.json", method = RequestMethod.GET)
    @ResponseBody
    public Object getSubStadiumListByClassify(@RequestParam(value = "pageIndex",defaultValue = "0",required = false) String pageIndex,
                                              @RequestParam(value = "pageSize", required = false) String pageSize,
                                              @RequestParam(value = "clientLng", required = true) String clientLng,
                                              @RequestParam(value = "clientLat", required = true) String clientLat,
                                              @RequestParam(value = "classify", required = false) String classify){
        //参数集合
        Map paramMap = DistanceUtils.returnLLSquarePoint(Double.parseDouble(clientLng),Double.parseDouble(clientLat),Double.parseDouble(config.defaultDistance));
        //客户经纬度
        paramMap.put("clientLng",clientLng);
        paramMap.put("clientLat",clientLat);
        if (StringUtils.isNullOrEmpty(pageSize)){
            paramMap.put("pageSize",config.pageSize);
        }else {
            paramMap.put("pageSize",pageSize);
        }
        paramMap.put("pageIndex",pageIndex);
        paramMap.put("classify",classify);

        List subStadiumList = stadiumService.getSubStadiumListByClassify(paramMap);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("subStadiumList",subStadiumList);
        resultMap.put("pageIndex",pageIndex);
        resultMap.put("count",subStadiumList!=null?subStadiumList.size():0);
        return RtnData.ok(resultMap);
    }


    /*
     * 根据主场馆ID获取主场馆详情
     * @RequestParam 主场馆
     * @return
     */
    @RequestMapping(value = "getMainStadiumDetailById.json", method = RequestMethod.GET)
    @ResponseBody
    public Object getMainStadiumDetailById(@RequestParam(value = "mainStadiumId", required = true) String mainStadiumId){
        //根据主场馆的ID获取主场馆详情
        Map stadiumDetail = stadiumService.getMainStadiumById(mainStadiumId);
        //根据主场馆ID获取图片的list
        List picList = stadiumService.getPicList(mainStadiumId);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("stadiumDetail",stadiumDetail);
        resultMap.put("picList",picList);
        return RtnData.ok(resultMap);
    }

    /*
     * 获取所有合作商列表
     * @return
     */
    @RequestMapping(value = "getAllMerchant.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllMerchant(){
        //获取所有合作商列表
        List getAllMerchantList = stadiumService.getAllMerchantList();
        Map<String,Object> resultMap = new HashMap<String,Object>();

        resultMap.put("getAllMerchantList",getAllMerchantList);
        return RtnData.ok(resultMap);
    }

    /*
     * 获取所有主场馆列表
     * @return
     */
    @RequestMapping(value = "getAllMainStadium.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllMainStadium(){
        //获取所有主场馆列表
        List getAllMainStadiumList = stadiumService.getAllMainStadiumList();
        Map<String,Object> resultMap = new HashMap<String,Object>();

        resultMap.put("getAllMainStadiumList",getAllMainStadiumList);
        return RtnData.ok(resultMap);
    }

    /**
     * 根据主场馆ID获取子场馆列表
     * @return
     */
    @RequestMapping(value = "getSubStadiumByMainId.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getSubStadiumListByMainId(@RequestParam(value = "mainStadiumId",required = true)String mainStadiumId){

        List subStadiumList = stadiumService.getSubStadiumListByMainId(mainStadiumId);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("subStadiumList",subStadiumList);
        return RtnData.ok(resultMap);
    }
}
