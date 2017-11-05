package com.cloud.mall.usermicriservice.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class EmptyChecker {

    private EmptyChecker(){}

    public static <T> boolean isEmpty(T t){
        if(null == t){
            return true;
        }
        if(t instanceof String){
            return ((String) t).length() == 0;
        }
        if(t instanceof Collection){
            return ((Collection) t).isEmpty();
        }
        if(t.getClass().isArray()){
            return  Arrays.asList(t).isEmpty();
        }
        if(t instanceof Map){
            return ((Map) t).isEmpty();
        }
        return false;
    }

    public static <T> boolean notEmpty(T t){
        return !isEmpty(t);
    }
}
