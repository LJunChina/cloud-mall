package com.cloud.mall.ccmweb.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器工具类
 *
 * @author Jon_China
 * @create 2017/11/18
 */
public final class ControllerUtil {
    private ControllerUtil(){}

    /**
     * 将request参数转换为map
     * @param request
     * @return
     */
    public static Map<String,String> getParamtersMap(HttpServletRequest request){
        Map<String,String[]> mapArray = request.getParameterMap();
        Map<String,String> resultMap = new HashMap<>();
        Set<Map.Entry<String, String[]>> entries =  mapArray.entrySet();
        for (Map.Entry<String,String[]> entry : entries){
            resultMap.put(entry.getKey(),EmptyChecker.isEmpty(entry) ? null : entry.getValue()[0]);
        }
        return resultMap;
    }
}
