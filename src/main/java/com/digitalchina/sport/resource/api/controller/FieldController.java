package com.digitalchina.sport.resource.api.controller;

import com.digitalchina.common.RtnData;
import com.digitalchina.common.result.Result;
import com.digitalchina.sport.resource.api.model.Field;
import com.digitalchina.sport.resource.api.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 场地control
 */
@RestController
@RequestMapping("/res/api/field/")
public class FieldController {

    //public static final Logger logger = LoggerFactory.getLogger(FieldController.class);

    @Autowired
    private FieldService fieldService;



    /**
     * 获取所有场地
     * @return
     */
    @RequestMapping(value="findAllField.json",method = RequestMethod.GET)
    @ResponseBody
    public RtnData findAllField() {
        List<Field> list = fieldService.findAll();
        Map<String,Object> reqMap=new HashMap<String, Object>();
        reqMap.put("list",list);
        return RtnData.ok(reqMap);
    }


}
