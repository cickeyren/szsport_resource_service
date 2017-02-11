package com.digitalchina.sport.order.api.service;


import com.digitalchina.sport.order.api.dao.StadiumDao;
import com.digitalchina.sport.order.api.model.MainStadium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 *
 */
@Service
public class StadiumService {

    @Autowired
    private StadiumDao stadiumDao;
    /**
     * 获取精选主场馆
     * @return
     */
    public List<Map<Object,Object>> getAllSpecialStadium(Map map){
        return stadiumDao.getAllSpecialStadium(map);
    }

    /**
     * 获取场馆列表
     * @return
     */
    public List getAllStadiumList(Map map){
        return stadiumDao.findAllStadiumList(map);
    }

    /**
     * 根据子场馆ID获得子场馆和所属父场馆详情
     * @param stadiumId
     * @return
     */
    public Map<String,String> getStadiumDetail(String stadiumId){
        return stadiumDao.getStadiumDetail(stadiumId);
    }

    /**
     * 根据场馆ID获取场馆图片列表
     * @param stadiumId
     * @return
     */
    public List<Map<Object,Object>> getAllPictureByStadiumId(String stadiumId){
        return stadiumDao.getAllPictureByStadiumId(stadiumId);
    }

    /**
     * 根据分类获取子场馆列表
     * @return
     */
    public List getSubStadiumListByClassify(Map map){
        return stadiumDao.findSubStadiumListByClassify(map);
    }

    /*
     * 根据主场馆ID获取主场馆详情
     * @param mainStadiumId
     * @return
     */
    public Map getMainStadiumById(String mainStadiumId){
        return stadiumDao.findMainStadiumById(mainStadiumId);
    }


    public List getPicList(String mainStadiumId){
        return stadiumDao.findPicList(mainStadiumId);
    }
}
