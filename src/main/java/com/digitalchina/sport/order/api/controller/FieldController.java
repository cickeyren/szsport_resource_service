package com.digitalchina.sport.order.api.controller;

import com.digitalchina.common.result.Result;
import com.digitalchina.sport.order.api.model.Field;
import com.digitalchina.sport.order.api.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 */
@RestController
@RequestMapping("/api/field")
public class FieldController {

    //public static final Logger logger = LoggerFactory.getLogger(FieldController.class);

    @Autowired
    private FieldService fieldService;

    @RequestMapping(value="findAllField",method = RequestMethod.GET)
    @ResponseBody
    public String findAllField(@RequestParam(required = false) String serviceId) {
        List<Field> list = fieldService.findAll();
        Map<String,Object> reqMap=new HashMap<String, Object>();
        reqMap.put("list",list);
        return Result.ok(reqMap);
    }
}
