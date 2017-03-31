package com.digitalchina.sport.resource.api.dao;

import com.digitalchina.sport.resource.api.model.TicketStrategyCommonCheckShieldTimeModel;
import com.digitalchina.sport.resource.api.model.YearStrategyTicketCheckUseableTimeModel;
import com.digitalchina.sport.resource.api.model.YearStrategyTicketModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 散客/年票dao
 */
@Mapper
public interface YearStrategyDao {
    /**
     * 根据年票策略ID查询年票策略
     * @param map
     * @return
     * @throws Exception
     */
    public YearStrategyTicketModel getYearStrategyTicketModelById(Map<String,Object> map) throws  Exception;

    /**
     * 根据年票策略ID去获取年票中关联的子场馆信息
     * @param id
     * @return
     * @throws Exception
     */
    public List<Map<String,Object>> getYearStrategyStadiumRelationsModelByYearStrategyId(String id) throws  Exception;

    /*
    *根据策略ID获取屏蔽时间列表
     */
    public List<TicketStrategyCommonCheckShieldTimeModel> getTicketStrategyCommonCheckShieldTimeModelList(String yearStrategyId) throws  Exception;

    /**
     * 根据策略ID获取可用时间列表
     * @param yearStrategyId
     * @return
     * @throws Exception
     */
    public List<YearStrategyTicketCheckUseableTimeModel> getYearStrategyTicketCheckUseableTimeModelList(String yearStrategyId) throws  Exception;

    /**
     * 根据分页参数查询策略列表
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map<String,Object>> getYearStrategyTicketModelInfoList(Map<String,Object> map) throws  Exception;

}
