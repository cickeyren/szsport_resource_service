package com.digitalchina.sport.resource.api.service;


import com.digitalchina.common.utils.StringUtil;
import com.digitalchina.sport.resource.api.dao.EquipmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 */
@Service
public class EquipmentService {

    @Autowired
    private EquipmentDao equipmentDao;

    public List<Map<String,Object>> findAllEquipBySubStadiumId(Map<String,Object> param) throws Exception{

        return equipmentDao.findAllEquipBySubStadiumId(param);
    }

    public Map<String,Object> checkEquipIsInStadium(Map<String,Object> param) throws Exception{
        Map<String,Object> reqMap=new HashMap<String, Object>();
        String equipmentId = "";
        String equipmentIds = "";
        if(!StringUtil.isEmpty(param.get("equipmentId"))){
            equipmentId = param.get("equipmentId").toString();
            List<Map<String,Object>> mapList = equipmentDao.findAllEquipIdBySubStadiumId(param);
            if (mapList.size()>0){
                for (int i =0;i<mapList.size();i++){
                    Map<String,Object> map = mapList.get(i);
                    equipmentIds += map.get("id")+",";
                }
                equipmentIds = equipmentIds.substring(0, equipmentIds.length() - 1);
                String[] ids = equipmentIds.split(",");
                if(StringUtil.isIn(equipmentId,ids)){
                    reqMap.put("checkResult","true");
                    reqMap.put("checkMessage","该设备属于该场馆");
                }else {
                    reqMap.put("checkResult","false");
                    reqMap.put("checkMessage","该设备不属于该场馆");
                }
            }else {
                reqMap.put("checkResult","false");
                reqMap.put("checkMessage","该场馆还未添加设备!");
            }
        }else {
            reqMap.put("checkResult","false");
            reqMap.put("checkMessage","设备号为空!");
        }
        return reqMap;
    }

    public int getCountByEquipmentId(String equipmentId){
        try {
            return equipmentDao.getCountByEquipmentId(equipmentId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public Map<String,Object> getDetailsByEquipmentId(Map<String,Object> map){
        try {
            return equipmentDao.getDetailsByEquipmentId(map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean bindEquipment(Map<String,Object> map) throws Exception{
       if(equipmentDao.bindEquipment(map) > 0){
           return true;
       }else return false;
    }

    public Map<String,Object> updateEquipment(Map<String,Object> map) throws Exception{
        Map<String,Object> reqMap=new HashMap<String, Object>();
        String oldEquipmentId = (String) map.get("oldEquipmentId");
        String newEquipmentId = (String) map.get("newEquipmentId");
        int oldCount = equipmentDao.getCountByEquipmentId(oldEquipmentId);
        int newCount = equipmentDao.getCountByEquipmentId(newEquipmentId);
        if(oldCount > 0 && newCount > 0){
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("id",newEquipmentId);
            Map<String,Object> newEquipDetails = equipmentDao.getDetailsByEquipmentId(params);//新的设备号是否被绑定
            String isBind ="";
            if(!StringUtil.isEmpty(newEquipDetails.get("isBind"))){
                isBind = (String) newEquipDetails.get("isBind");
            }
            if (isBind.equals("1")){
                reqMap.put("returnKey","false");
                reqMap.put("returnMessage","该设备号已被绑定");
            }else {
                //旧的设备号解绑
                Map<String,Object> unBindparams = new HashMap<String,Object>();
                unBindparams.put("isBind","0");
                unBindparams.put("deviceNumber","");
                unBindparams.put("id",map.get("oldEquipmentId"));
                equipmentDao.bindEquipment(unBindparams);
                //旧的设备号解绑end

                Map<String,Object> bindparams = new HashMap<String,Object>();
                bindparams.put("isBind","1");
                bindparams.put("deviceNumber",map.get("deviceNumber"));
                bindparams.put("id",map.get("newEquipmentId"));
                if(equipmentDao.bindEquipment(bindparams) > 0){
                    reqMap.put("returnKey","true");
                    reqMap.put("returnMessage","修改绑定设备号成功");
                }else {
                    reqMap.put("returnKey","false");
                    reqMap.put("returnMessage","修改绑定设备号失败");
                }
            }
        }else {
            reqMap.put("returnKey","false");
            reqMap.put("returnMessage","设备号不存在");
        }

        return reqMap;
    }
}
