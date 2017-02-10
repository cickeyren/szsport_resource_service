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
 * 场地control
 */
@RestController
@RequestMapping("/api/field/")
public class FieldController {

    //public static final Logger logger = LoggerFactory.getLogger(FieldController.class);

    @Autowired
    private FieldService fieldService;

    /**
     * 获取所有场地
     * @return
     */
    @RequestMapping(value="findAllField",method = RequestMethod.GET)
    @ResponseBody
    public String findAllField() {
        List<Field> list = fieldService.findAll();
        Map<String,Object> reqMap=new HashMap<String, Object>();
        reqMap.put("list",list);
        return Result.ok(reqMap);
    }
}
