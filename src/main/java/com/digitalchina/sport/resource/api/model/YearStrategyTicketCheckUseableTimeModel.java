package com.digitalchina.sport.resource.api.model;

/**
 * 年票策略可用时间段
 * @Author:yangyt
 * @Description
 * @Date:Created in 19:01 2017/2/13
 */
public class YearStrategyTicketCheckUseableTimeModel {
    /**
     * 表ID
     */
    private String id;
    /**
     * 该票类似生成的票策略ID
     */
    private String ticketStrategyId;
    /**
     * 时间限制 0：每日 1：每周
     */
    private String checkLimitedDateType;
    /**
     *屏蔽起始时间
     */
    private String useableStartTime;
    /**
     * 屏蔽结束时间
     */
    private String useableEndTime;
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

    public String getTicketStrategyId() {
        return ticketStrategyId;
    }

    public void setTicketStrategyId(String ticketStrategyId) {
        this.ticketStrategyId = ticketStrategyId;
    }

    public String getCheckLimitedDateType() {
        return checkLimitedDateType;
    }

    public void setCheckLimitedDateType(String checkLimitedDateType) {
        this.checkLimitedDateType = checkLimitedDateType;
    }

    public String getUseableStartTime() {
        return useableStartTime;
    }

    public void setUseableStartTime(String useableStartTime) {
        this.useableStartTime = useableStartTime;
    }

    public String getUseableEndTime() {
        return useableEndTime;
    }

    public void setUseableEndTime(String useableEndTime) {
        this.useableEndTime = useableEndTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
         this.createTime = createTime;
    }

}
