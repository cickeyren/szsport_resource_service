package com.digitalchina.sport.order.api.controller;

import com.digitalchina.sport.order.api.common.config.Config;
import com.digitalchina.common.result.Result;
import com.digitalchina.common.utils.DistanceUtils;
import com.digitalchina.sport.order.api.service.StadiumService;
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
    public String getAllSpecialStadium() {
        String s = config.pageSize;
        List<Map<Object,Object>> mapList = stadiumService.getAllSpecialStadium();
        Map<String,Object> reqMap=new HashMap<String, Object>();
        reqMap.put("list",mapList);
        return Result.ok(reqMap);
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
                                    @RequestParam(value = "clientLng", required = false) String clientLng,
                                    @RequestParam(value = "clientLat", required = false) String clientLat){
        Map paramMap = DistanceUtils.returnLLSquarePoint(Double.parseDouble(clientLng),Double.parseDouble(clientLat),Double.parseDouble(config.pageSize));
        paramMap.put("clientLng",clientLng);
        paramMap.put("clientLat",clientLat);
        if (pageSize.isEmpty()){
            paramMap.put("pageSize",config.pageSize);
        }else {
            paramMap.put("pageSize",pageSize);
        }
        paramMap.put("pageIndex",pageIndex);
        List stadiumList = stadiumService.getAllStadiumList(paramMap);
        Map<String,Object> reqMap=new HashMap<String, Object>();
        reqMap.put("stadiumList",stadiumList);
        return Result.ok(reqMap);

    }



    /*
     *
     */

}
