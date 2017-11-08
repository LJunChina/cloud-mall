package com.cloud.mall.usermicriservice.utils;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

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

    @Test
    public void testEncrypt() throws Exception{
        ClassPathResource resource = new ClassPathResource("/publicKey.keystore");
        String keyStr = RSAEncrypt.loadKeyByFile(resource.getFile().getPath());
        RSAPublicKey publicKey = RSAEncrypt.loadPublicKeyByStr(keyStr);
        byte[] encrypt = RSAEncrypt.encrypt(publicKey,"123456".getBytes());

        System.out.println(new java.lang.String(encrypt,"utf-8"));
        byte[] pass = "fTBbHT6Uq+tNAkR43xkua9pfyJzUIds52XlAJ2CX7tKfwIPMl52pvCJ0e4r+TxYPNqxCL3ki2dek2ndLoj4PFdPOjrUBvufi3ZAmkhS3jOyJhg08+5kGN+9q8LI6FVTsqkMjn6O0dEuebVx94ivBJOS5XFmRyCOUMp2Z0U9z5lk=".getBytes();

        ClassPathResource classPathResource = new ClassPathResource("/privateKey.keystore");
        String priveteKeyStr = RSAEncrypt.loadKeyByFile(classPathResource.getFile().getPath());
        RSAPrivateKey privateKey = RSAEncrypt.loadPrivateKeyByStr(priveteKeyStr);
        byte[] dencrypt = RSAEncrypt.decrypt(privateKey,pass);
        Assert.assertEquals("123456",new String(dencrypt));
    }


}
