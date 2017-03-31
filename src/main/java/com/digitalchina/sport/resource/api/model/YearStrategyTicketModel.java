package com.digitalchina.sport.resource.api.model;

/**
 * yangyt
 * 年卡策略票务模型
 */
public class YearStrategyTicketModel {
    /**
     * 表ID
     */
    private String id;
    /**
     * 套票类型 0：单票 1：场地票
     */
    private String ticketType;
    /**
     * 门票名称
     */
    private String ticketName;
    /**
     *合作商户ID
     */
    private String merchantId;
    /**
     *0:线上 1：自助机售卖
     */
    private String sellWay;
    /**
     *使用有效期类型 0：预订后x天有效 1：固定有效期
     */
    private String orderEffectiveType;
    /**
     * order_effective_type=0时预订之后固定日期有效
     */
    private String orderFixDay;
    /**
     *有效期起始时间(无论是有效天数还是固定时间都生成该时间)
     */
    private String orderEffectiveStartTime;
    /**
     *有效期终止时间有效期结束时间(无论是有效天数还是固定时间都生成该时间)
     */
    private String orderEffectiveEndTime;
    /**
     *退款规则 0：不可退 1：随时退 2：条件退
     */
    private String orderRefundRule;
    /**
     *验票凭证 0:验证码 1：身份证 2：市民卡
     */
    private String checkTicketType;
    /**
     *验票渠道 0:支持闸机验票1:支持窗口验票 2:支持手持终端验票
     */
    private String checkTicketWay;
    /**
     * 该票设置可用总次数 -1表示不限 其他：限次
     */
    private String checkTicketAvailableTimes;
    /**
     * 每日限次
     */
    private String checkDailyLimitedTimes;
    /**
     * 时间限制 0：每日 1：每周
     */
    private String checkLimitedDateType;
    /**
     *如果时间限制为每周那么显示具体的限制星期几 用;隔checkLimitedWeekDetails开
     */
    private String checkLimitedWeekDetails;

    /**
//     * 是否限时 0：不限 1：限时
//     */
//    private String checkLimitedTimeType
//
    /**
     *是否限时 -1：不限 其他：限时小时数
     */
    private String checkLimitedHours;
    /**
     * 销售价
     */
    private String sellPrice;
    /**
     *成本价
     */
    private String costPrice;
    /**
     * 门市价
     */
    private String storePrice;
    /**
     * 预订说明
     */
    private String orderDescription;
    /**
     *退票说明
     */
    private String refundDescription;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 0：下线 1：上线
     */
    private String strategyState;

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

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getSellWay() {
        return sellWay;
    }

    public void setSellWay(String sellWay) {
        this.sellWay = sellWay;
    }

    public String getOrderEffectiveType() {
        return orderEffectiveType;
    }

    public void setOrderEffectiveType(String orderEffectiveType) {
        this.orderEffectiveType = orderEffectiveType;
    }

    public String getOrderEffectiveStartTime() {
        return orderEffectiveStartTime;
    }

    public void setOrderEffectiveStartTime(String orderEffectiveStartTime) {
        this.orderEffectiveStartTime = orderEffectiveStartTime;
    }

    public String getOrderEffectiveEndTime() {
        return orderEffectiveEndTime;
    }

    public void setOrderEffectiveEndTime(String orderEffectiveEndTime) {
        this.orderEffectiveEndTime = orderEffectiveEndTime;
    }

    public String getOrderRefundRule() {
        return orderRefundRule;
    }

    public void setOrderRefundRule(String orderRefundRule) {
        this.orderRefundRule = orderRefundRule;
    }

    public String getCheckTicketType() {
        return checkTicketType;
    }

    public void setCheckTicketType(String checkTicketType) {
        this.checkTicketType = checkTicketType;
    }

    public String getCheckTicketWay() {
        return checkTicketWay;
    }

    public void setCheckTicketWay(String checkTicketWay) {
        this.checkTicketWay = checkTicketWay;
    }

    public String getCheckTicketAvailableTimes() {
        return checkTicketAvailableTimes;
    }

    public void setCheckTicketAvailableTimes(String checkTicketAvailableTimes) {
        this.checkTicketAvailableTimes = checkTicketAvailableTimes;
    }

    public String getCheckDailyLimitedTimes() {
        return checkDailyLimitedTimes;
    }

    public void setCheckDailyLimitedTimes(String checkDailyLimitedTimes) {
        this.checkDailyLimitedTimes = checkDailyLimitedTimes;
    }

    public String getCheckLimitedDateType() {
        return checkLimitedDateType;
    }

    public void setCheckLimitedDateType(String checkLimitedDateType) {
        this.checkLimitedDateType = checkLimitedDateType;
    }

    public String getCheckLimitedWeekDetails() {
        return checkLimitedWeekDetails;
    }

    public void setCheckLimitedWeekDetails(String checkLimitedWeekDetails) {
        this.checkLimitedWeekDetails = checkLimitedWeekDetails;
    }

    public String getCheckLimitedHours() {
        return checkLimitedHours;
    }

    public void setCheckLimitedHours(String checkLimitedHours) {
        this.checkLimitedHours = checkLimitedHours;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getStorePrice() {
        return storePrice;
    }

    public void setStorePrice(String storePrice) {
        this.storePrice = storePrice;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getRefundDescription() {
        return refundDescription;
    }

    public void setRefundDescription(String refundDescription) {
        this.refundDescription = refundDescription;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOrderFixDay() {
        return orderFixDay;
    }

    public void setOrderFixDay(String orderFixDay) {
        this.orderFixDay = orderFixDay;
    }

    public String getStrategyState() {
        return strategyState;
    }

    public void setStrategyState(String strategyState) {
        this.strategyState = strategyState;
    }
}
