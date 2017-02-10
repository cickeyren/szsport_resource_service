package com.digitalchina.sport.order.api.model;

/**
 * Created by asus on 2016/12/27.
 * 类目
 */
//@Data
public class Classify {
    private int cid;
    private int levelId;
    private int pid;
    private String categoryName;
    private String sort;
    private String picture;
    private String ishavesub;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIshavesub() {
        return ishavesub;
    }

    public void setIshavesub(String ishavesub) {
        this.ishavesub = ishavesub;
    }
}
