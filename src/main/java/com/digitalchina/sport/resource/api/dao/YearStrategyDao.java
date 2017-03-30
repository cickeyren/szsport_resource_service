package com.digitalchina.sport.resource.api.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 散客/年票dao
 */
@Mapper
public interface YearStrategyDao {
    /**
     * 根据分页参数查询策略列表
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map<String,Object>> getYearStrategyTicketModelInfoList(Map<String,Object> map) throws  Exception;

}
