package com.cloud.mall.usermicriservice.utils;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

public class RSAEncryptTest extends UserMicriserviceApplicationTests {


    @Test
    public void testGenKeyPair(){
        RSAEncrypt.genKeyPair("E:/");
    }

    @Test
    public void testLoadPublicKey() throws Exception{
        ClassPathResource resource = new ClassPathResource("/publicKey.keystore");
        Assert.assertNotNull(RSAEncrypt.loadKeyByFile(resource.getFile().getPath()));
    }


}
