package com.digitalchina.sport.resource.api.model;

/**年票生成策略与子场馆对应关系
 * @Author:yangyt
 * @Description
 * @Date:Created in 19:06 2017/2/13
 */
public class YearStrategyStadiumRelationsModel {
    /**
     * 表ID
     */
    private String id;

    /**
     * 该票类似生成的票策略ID
     */
    private String ticketStrategyId;
    /**
     * 子场馆分类
     */
    private String classify;
    /**
     * 主场馆ID
     */
    private String mainStadiumId;
    /**
     * 子场馆ID
     */
    private String subStadiumId;
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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getMainStadiumId() {
        return mainStadiumId;
    }

    public void setMainStadiumId(String mainStadiumId) {
        this.mainStadiumId = mainStadiumId;
    }

    public String getSubStadiumId() {
        return subStadiumId;
    }

    public void setSubStadiumId(String subStadiumId) {
        this.subStadiumId = subStadiumId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
