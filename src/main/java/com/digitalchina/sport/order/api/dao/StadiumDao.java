package com.digitalchina.sport.order.api.dao;



import com.digitalchina.sport.order.api.model.Field;
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

    /**
     * 根据子场馆ID获得子场馆和所属父场馆详情
     * @param stadiumId
     * @return
     */
    Map<String,String> getStadiumDetail(String stadiumId);

    /**
     * 根据场馆ID获取场馆图片列表
     * @param stadiumId
     * @return
     */
    List<Map<Object,Object>> getAllPictureByStadiumId(String stadiumId);
}
