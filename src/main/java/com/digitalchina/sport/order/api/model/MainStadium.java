package com.digitalchina.sport.order.api.model;

/**
 * 主场地
 */
public class MainStadium {

    private String id;
    private String name;
    private String provincialLevel;
    private String cityLevel;
    private String districtLevel;
    private String tradingArea;
    private String address;
    private String telephone;
    private String openTime;
    private String introduction;
    /**
     * 经度
     */
    private String lng;
    /**
     * 纬度
     */
    private String lat;
    /**
     * 状态(1正常0闭馆2下线)
     * 下线状态，前台不可见；闭馆状态前台显示【不可订】默认下线状态
     */
    private String status;
    private String merchantId;
    private String classify;
    /**
     * 是否精选0：非精选1:精选
     */
    private String isSpecial;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvincialLevel() {
        return provincialLevel;
    }

    public void setProvincialLevel(String provincialLevel) {
        this.provincialLevel = provincialLevel;
    }

    public String getCityLevel() {
        return cityLevel;
    }

    public void setCityLevel(String cityLevel) {
        this.cityLevel = cityLevel;
    }

    public String getDistrictLevel() {
        return districtLevel;
    }

    public void setDistrictLevel(String districtLevel) {
        this.districtLevel = districtLevel;
    }

    public String getTradingArea() {
        return tradingArea;
    }

    public void setTradingArea(String tradingArea) {
        this.tradingArea = tradingArea;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(String isSpecial) {
        this.isSpecial = isSpecial;
    }
}
