package com.digitalchina.sport.resource.api.dao;



import com.digitalchina.sport.resource.api.model.Field;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 设备dao
 */
@Mapper
public interface EquipmentDao {
    /**
     *根据子场馆id查询该场馆使用的所有设备
     * @param
     * @return
     */
    List<Map<String,Object>> findAllEquipBySubStadiumId(Map<String,Object> param) throws Exception;

    /**
     * 根据子场馆id查询所有启用的设备id
     * @param param
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> findAllEquipIdBySubStadiumId(Map<String,Object> param) throws Exception;

    /**
     * 根据设备id查询设备是否存在
     * @param equipmentId
     * @return
     */
    int getCountByEquipmentId(String equipmentId) throws Exception;

    /**
     * 根据设备id查询设备详情
     * @param param
     * @return
     * @throws Exception
     */
    Map<String,Object> getDetailsByEquipmentId(Map<String,Object> param) throws Exception;

    /**
     * 绑定设备号
     * @param param
     * @return
     * @throws Exception
     */
    int bindEquipment(Map<String,Object> param)throws Exception;
}
