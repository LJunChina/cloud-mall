package com.cloud.mall.usermicriservice.utils;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
import org.junit.Assert;
import org.junit.Test;

public class RSAEncryptTest extends UserMicriserviceApplicationTests {


    @Test
    public void testGenKeyPair(){
        RSAEncrypt.genKeyPair("/");
    }

    @Test
    public void testLoadPublicKey() throws Exception{
        Assert.assertNotNull(RSAEncrypt.loadPublicKeyByFile("E:/"));
    }


}
