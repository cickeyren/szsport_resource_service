package com.digitalchina.sport.order.api.controller;

import com.digitalchina.common.result.Result;
import com.digitalchina.sport.order.api.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 */
@RestController
@RequestMapping("/api/stadium/")
public class StadiumController {

    //public static final Logger logger = LoggerFactory.getLogger(FieldController.class);

    @Autowired
    private StadiumService stadiumService;

    @RequestMapping(value="getAllSpecialStadium",method = RequestMethod.GET)
    @ResponseBody
    public String getAllSpecialStadium() {
        List<Map<Object,Object>> mapList = stadiumService.getAllSpecialStadium();
        Map<String,Object> reqMap=new HashMap<String, Object>();
        reqMap.put("list",mapList);
        return Result.ok(reqMap);
    }
}
