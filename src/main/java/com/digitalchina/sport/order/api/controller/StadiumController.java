package com.digitalchina.sport.order.api.controller;

import com.digitalchina.sport.order.api.common.config.Config;
import com.digitalchina.common.result.Result;
import com.digitalchina.common.utils.DistanceUtils;
import com.digitalchina.sport.order.api.model.MainStadium;
import com.digitalchina.sport.order.api.service.StadiumService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 场馆control
 */
@RestController
@RequestMapping("/api/stadium/")
public class StadiumController {

    //public static final Logger logger = LoggerFactory.getLogger(FieldController.class);

    @Autowired
    private Config config;
    @Autowired
    private StadiumService stadiumService;

    /**
     * 获取所有精选场馆
     * @return
     */
    @RequestMapping(value="getAllSpecialStadium",method = RequestMethod.GET)
    @ResponseBody
    public String getAllSpecialStadium( @RequestParam(value = "clientLng", required = true) String clientLng,
                                        @RequestParam(value = "clientLat", required = true) String clientLat) {
        String s = config.pageSize;
        Map paramMap = DistanceUtils.returnLLSquarePoint(Double.parseDouble(clientLng),Double.parseDouble(clientLat),Double.parseDouble(config.defaultDistance));
        paramMap.put("clientLng",clientLng);
        paramMap.put("clientLat",clientLat);
        List<Map<Object,Object>> mapList = stadiumService.getAllSpecialStadium(paramMap);
        Map<String,Object> resultMap=new HashMap<String, Object>();
        resultMap.put("list",mapList);
        return Result.ok(resultMap);
    }

    /**
     * 获取所有场馆列表(根据用户当前经纬排序)
     * @return
     */
    @RequestMapping(value = "getAllStadiumList", method = RequestMethod.GET)
    @ResponseBody
    //用户传递来的经纬度
    public String getAllStadiumList(@RequestParam(value = "pageIndex",defaultValue = "0", required = false) String pageIndex,
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
        return Result.ok(resultMap);

    }

    /**
     * 根据子场馆ID获得子场馆和所属父场馆详情
     * 主场馆的图片展示
     * @param statudiumId
     * @return
     */
    @RequestMapping(value="getStadiumDetail",method = RequestMethod.GET)
    @ResponseBody
    public String getStadiumDetail(@RequestParam(value = "statudiumId", required = false) String statudiumId){
        Map<String,Object> reqMap=new HashMap<String, Object>();//返回的map

        Map<String,String> stadiumDetail = stadiumService.getStadiumDetail(statudiumId);
        String mianStadiumId = stadiumDetail.get("pid");//获取该子场馆的主场馆ID
        if(mianStadiumId!=null && !"".equals(mianStadiumId)){
            List<Map<Object,Object>> picList = stadiumService.getAllPictureByStadiumId(mianStadiumId);
            reqMap.put("picList",picList);
        }

        reqMap.put("stadiumDetail",stadiumDetail);
        return Result.ok(reqMap);
    }

    /*
     * 根据分类获取子场馆列表
     * @RequestParam 用户经纬度，选中的分类，pageIndex，pageSize
     * @return
     */
    @RequestMapping(value = "getSubStadiumListByClassify", method = RequestMethod.GET)
    @ResponseBody
    public String getSubStadiumListByClassify(@RequestParam(value = "pageIndex",defaultValue = "0",required = false) String pageIndex,
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
        return Result.ok(resultMap);
    }


    /*
     * 根据主场馆ID获取主场馆详情
     * @RequestParam 主场馆
     * @return
     */
    @RequestMapping(value = "getMainStadiumDetailById", method = RequestMethod.GET)
    @ResponseBody
    public String getMainStadiumDetailById(@RequestParam(value = "mainStadiumId", required = true) String mainStadiumId){
        //根据主场馆的ID获取主场馆详情
        Map stadiumDetail = stadiumService.getMainStadiumById(mainStadiumId);
        //根据主场馆ID获取图片的list
        List picList = stadiumService.getPicList(mainStadiumId);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("stadiumDetail",stadiumDetail);
        resultMap.put("picList",picList);
        return Result.ok(resultMap);
    }
}
