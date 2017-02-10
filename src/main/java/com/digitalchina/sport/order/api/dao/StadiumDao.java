package com.digitalchina.sport.order.api.dao;



import com.digitalchina.sport.order.api.model.Field;
import com.digitalchina.sport.order.api.model.MainStadium;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 场馆dao
 */
@Mapper
public interface StadiumDao {
    /**
     * 获取精选主场馆
     * @return
     */
    List<Map<Object,Object>> getAllSpecialStadium();


    /**
     * 获取所有场馆列表
     * @return
     */
    List findAllStadiumList(Map map);

    /*
     * 根据ID查询会馆详情
     */
    MainStadium findStadiumDetailById(String Id);

}
