package com.digitalchina.sport.resource.api.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author:wangw
 * @Description:场地票管理
 * @Date:Created on 2017/3/16.
 */
@Mapper
public interface SiteTicketDao {
    /**
     * 获取下单需要的场地票信息
     * @param map
     * @return
     */
    public Map<String, Object> getSiteTicketInfoToOrder(Map<String, Object> map);

    /**
     * 根据场馆获取生效的场地票列表信息
     * @param map
     * @return
     */
    public List<Map<String, Object>> getValidSiteTicketList(Map<String, Object> map);

    /**
     * 根据场地票获取策略场地列表信息
     * @param map
     * @return
     */
    public List<Map<String, Object>> getFieldListByTicket(Map<String, Object> map);

    /**
     * 获取场地列表信息
     * @param map
     * @return
     */
    public List<Map<String, Object>> getFieldListByIds(Map<String, Object> map);

    /**
     * 根据场地票获取场地开放时段
     * @param map
     * @return
     */
    public List<Map<String, Object>> getTimeIntervalByTicket(Map<String, Object> map);

    /**
     * 根据场地票获取价格策略
     * @param map
     * @return
     */
    public List<Map<String, Object>> getStrategyByTicket(Map<String, Object> map);

    /**
     * 获取有效的场地状态策略，用于场地票屏蔽、可订购状态修改
     * @param map
     * @return
     */
    public List<Map<String, Object>> getValidFieldStateList(Map<String, Object> map);

    /**
     * 根据日期获取所有的场地订购信息
     * @param map
     * @return
     */
    public List<Map<String, Object>> getOrderFieldTime(Map<String, Object> map);
}
