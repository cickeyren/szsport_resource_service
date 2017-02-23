package com.digitalchina.sport.resource.api.controller;

import com.digitalchina.common.RtnData;
import com.digitalchina.sport.resource.api.model.Field;
import com.digitalchina.sport.resource.api.service.EquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备control
 */
@RestController
@RequestMapping("/res/api/equip/")
public class EquipmentController {

    public static final Logger logger = LoggerFactory.getLogger(FieldController.class);

    @Autowired
    private EquipmentService equipmentService;

    /**
     * 根据子场馆id查询该场馆使用的所有设备
     * @param subStadiumId
     * @param status
     * @return
     */
    @RequestMapping(value="findAllEquipBySubStadiumId.json",method = RequestMethod.GET)
    @ResponseBody
    public RtnData findAllEquipBySubStadiumId(@RequestParam(value = "subStadiumId", required = true) String subStadiumId,
                                              @RequestParam(value = "status", required = false) String status) {

        Map<String,Object> param = new HashMap<String, Object>();
        Map<String,Object> reqMap=new HashMap<String, Object>();
        param.put("subStadiumId",subStadiumId);
        param.put("status",status);
        try {
            List<Map<String,Object>> eqlist = equipmentService.findAllEquipBySubStadiumId(param);
            reqMap.put("list",eqlist);
            return RtnData.ok(reqMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询失败，",e);
            return RtnData.fail("查询失败!");
        }
    }


    /**
     * 根据设备编号和子场馆编号查询该设备是否属于该场馆
     * @param subStadiumId
     * @param equipmentId
     * @return
     */
    @RequestMapping(value="checkEquipIsInStadium.json",method = RequestMethod.GET)
    @ResponseBody
    public RtnData checkEquipIsInStadium(@RequestParam(value = "subStadiumId", required = true) String subStadiumId,
                                         @RequestParam(value = "equipmentId", required = true) String equipmentId) {

        Map<String,Object> param = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
        param.put("subStadiumId",subStadiumId);
        param.put("equipmentId",equipmentId);
        try {
            reqMap = equipmentService.checkEquipIsInStadium(param);
            return RtnData.ok(reqMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询失败，",e);
            return RtnData.fail("查询失败!");
        }
    }

    /**
     * 根据设备编号查询设备编号是否可用
     * 存在的才能添加，不存在不能添加
     * @param equipmentId
     * @return
     */
    @RequestMapping(value="insertEquipmentId.json",method = RequestMethod.GET)
    @ResponseBody
    public RtnData<Object> insertEquipmentId(@RequestParam(value = "equipmentId", required = true) String equipmentId) {

        Map<String,Object> param = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
        param.put("id",equipmentId);
        try {
            int count = equipmentService.getCountByEquipmentId(param);
            if(count > 0){
                reqMap.put("equipmentDetails",equipmentService.getDetailsByEquipmentId(param));
                return RtnData.ok(reqMap);
            }else {
                return RtnData.fail("该设备不存在!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询失败，",e);
            return RtnData.fail("查询失败!");
        }
    }
}
