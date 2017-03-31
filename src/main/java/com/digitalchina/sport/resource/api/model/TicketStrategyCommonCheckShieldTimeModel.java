package com.digitalchina.sport.resource.api.model;

/**
 * 票务策略通用验票屏蔽时间
 * @Author:yangyt
 * @Description
 * @Date:Created in 20:32 2017/2/13
 */
public class TicketStrategyCommonCheckShieldTimeModel {
    /**
     * 表ID
     */
    private String id;
    /**
     * 票类型 散票 1：场地票 2：通票
     */
    private String ticketType;
    /**
     * 该票类似生成的票策略ID
     */
    private String ticketStrategyId;
    /**
     * 屏蔽起始时间
     */
    private String shieldStartTime;
 /**
     * 屏蔽结束时间
     */
    private String shieldEndTime;
    /**
     * 创建时间
     */
    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketStrategyId() {
        return ticketStrategyId;
    }

    public void setTicketStrategyId(String ticketStrategyId) {
        this.ticketStrategyId = ticketStrategyId;
    }

    public String getShieldStartTime() {
        return shieldStartTime;
    }

    public void setShieldStartTime(String shieldStartTime) {
        this.shieldStartTime = shieldStartTime;
    }

    public String getShieldEndTime() {
        return shieldEndTime;
    }

    public void setShieldEndTime(String shieldEndTime) {
        this.shieldEndTime = shieldEndTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
         this.createTime = createTime;
    }
}
