package com.digitalchina.common.utils;

import java.util.HashMap;
import java.util.Map;


public class DistanceUtils {
	static double DEF_PI = 3.14159265359; // PI
	static double DEF_2PI= 6.28318530712; // 2*PI
	static double DEF_PI180= 0.01745329252; // PI/180.0
	static double DEF_R =6370693.5; // radius of earth
	/**
     * 计算经纬度点对应正方形4个点的坐标
     *
     * @param longitude
     * @param latitude
     * @param distance
     * @return
     */
    public static Map<String, Object> returnLLSquarePoint(double longitude,
            double latitude, double distance) {
        Map<String, Object> squareMap = new HashMap<String, Object>();
        // 计算经度弧度,从弧度转换为角度
        double dLongitude = 2 * (Math.asin(Math.sin(distance
                / (2 * DEF_R))
                / Math.cos(Math.toRadians(latitude))));
        dLongitude = Math.toDegrees(dLongitude);
        // 计算纬度角度
        Double dLatitude = distance / DEF_R;
        dLatitude = Math.toDegrees(dLatitude);
        Double topRightLat = latitude + dLatitude;
        Double topRightLng = longitude + dLongitude;
        Double bottomRightLat =latitude - dLatitude;
        Double bottomRightLng = longitude - dLongitude;

        squareMap.put("maxLat", topRightLat);
        squareMap.put("maxLng", topRightLng);
        squareMap.put("minLat", bottomRightLat);
        squareMap.put("minLng", bottomRightLng);
        return squareMap;
    }
    public static void main(String[] args) {
		System.out.println(returnLLSquarePoint(120.553754, 31.882094, 2000));
	}
}
