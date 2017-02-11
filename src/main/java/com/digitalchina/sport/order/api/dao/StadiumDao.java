package com.digitalchina.sport.order.api.dao;


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
    List<Map<Object,Object>> getAllSpecialStadium(Map map);


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
    /*
     * 根据classify查询子场馆列表
     */
    List findSubStadiumListByClassify(Map map);

    //根据主场馆ID获取主场馆详情
    Map findMainStadiumById(String mainStadiumId);

    /**
     * 根据场馆ID获取图片列表
     * @return
     */
    List findPicList(String mainStadiumId);

}
