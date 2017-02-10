package com.digitalchina.sport.order.api.service;


import com.digitalchina.sport.order.api.dao.StadiumDao;
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
    
}
