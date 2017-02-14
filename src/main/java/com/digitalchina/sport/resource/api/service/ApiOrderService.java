package com.digitalchina.sport.resource.api.service;

import com.digitalchina.sport.resource.api.dao.ApiOrderDao;
import com.digitalchina.sport.resource.api.model.ApiOrder;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by xiaoning.sun on 2016/12/3.
 */
@Service
public class ApiOrderService {
    @Autowired
    private ApiOrderDao apiOrderDao;


    public ApiOrder getOrderInfoByPK (Integer id)
    {
        Map<String,Object> params = Maps.newHashMap();
        params.put("id",id);
        return apiOrderDao.getOrderInfoByPK(params);
    }

}
