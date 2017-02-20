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

    public int getCountByEquipmentId(Map<String,Object> map) throws Exception {
        return equipmentDao.getCountByEquipmentId(map);
    }
}
