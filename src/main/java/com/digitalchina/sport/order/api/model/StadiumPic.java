package com.digitalchina.sport.order.api.model;

import java.sql.Timestamp;

/**
 * 场地
 */
public class StadiumPic {

    private String id;
    private String picAddress;
    /**
     * 是否是首图（0不是，1是）
     */
    private String isFirst;
    /**
     *对应场馆id
     */
    private String stadiumId;
    private Timestamp create_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicAddress() {
        return picAddress;
    }

    public void setPicAddress(String picAddress) {
        this.picAddress = picAddress;
    }

    public String getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(String isFirst) {
        this.isFirst = isFirst;
    }

    public String getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}
