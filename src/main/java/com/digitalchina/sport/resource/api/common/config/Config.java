package com.digitalchina.sport.resource.api.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Config {
    @Value("${sport.order.pagesize}")
    public String pageSize;

}
