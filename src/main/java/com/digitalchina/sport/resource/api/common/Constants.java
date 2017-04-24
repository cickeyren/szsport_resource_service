package com.digitalchina.sport.resource.api.common;

public class Constants {
    /* 平台代码规范常量 */
    /**
     * 通用成功代码
     */
    public final static String RTN_CODE_SUCCESS = "000000";
    /**
     * 通用错误代码
     */
    public final static String RTN_CODE_FAIL = "999999";

    public final static String RTN_STATUS_SUCCESS = "OK";
    public final static String RTN_STATUS_ERROR = "ERROR";


    /**
     * 通用错误信息
     */
    public final static String RTN_MESSAGE_ERROR = "请求发生异常";
    /**
     * 缓存的key
     */
    public static final String THING_ALL_KEY   = "\"thing_all\"";
    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
     */
    public static final String DEMO_CACHE_NAME = "demo";
}
