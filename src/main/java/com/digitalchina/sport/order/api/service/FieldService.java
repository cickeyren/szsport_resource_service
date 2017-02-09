package com.digitalchina.sport.order.api.service;


import com.digitalchina.sport.order.api.dao.FieldDao;
import com.digitalchina.sport.order.api.model.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 */
@Service
public class FieldService {

    @Autowired
    private FieldDao fieldDao;

    public List<Field> findAll(){
        return fieldDao.findAll();
    }

}
