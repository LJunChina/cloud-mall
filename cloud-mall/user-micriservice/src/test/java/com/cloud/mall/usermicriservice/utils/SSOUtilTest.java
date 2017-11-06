package com.cloud.mall.usermicriservice.utils;

import org.junit.Test;

import java.util.UUID;

public class SSOUtilTest {

    @Test
    public void testGeneratorTokenId(){
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println(SSOUtil.generatorTokenId());
        //System.out.println(UUID.randomUUID().toString().toUpperCase().repla);
    }
}
