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
    public List<Map<Object,Object>> getAllSpecialStadium(){
        return stadiumDao.getAllSpecialStadium();
    }

    /**
     * 获取场馆列表
     * @return
     */
    public List getAllStadiumList(Map map){
        return stadiumDao.findAllStadiumList(map);
    }

    /**
     * 根据ID获取场馆详
     * @return
     */
    public MainStadium getStadiumDetailById(String Id){
        return stadiumDao.findStadiumDetailById(Id);
    }
}
