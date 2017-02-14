package com.digitalchina.sport.resource.api.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(locations = "classpath:application.properties",prefix="application")

public class Config {
    @Value("${sport.order.pagesize}")
    public String pageSize;

    @Value("${sport.default.distance}")
    public  String defaultDistance;

    /**
     * #体育局后台管理访问接口地址
     */
    @Value("${sportmgr.url}")
    public  String SPORT_MGR_URL;

}
