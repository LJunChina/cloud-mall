package com.cloud.mall.usermicriservice.utils;

import java.util.Random;

public class SSOUtil {

    private SSOUtil(){}

    public static String generatorTokenId(){
        Random random = new Random();
        char[] tokenChars = new char[20];
        char[] letters = new char[36];
        for (int i = (int)'A';i<= (int)'Z';i++){
            letters[i-65] = (char) i;
        }
        for (int i = 0;i < 20; i++){
            if(i%2 == 0){
                tokenChars[i] = Integer.valueOf(random.nextInt(9)).toString().toCharArray()[0];
            }else {
                tokenChars[i] = letters[random.nextInt(35)];
            }
        }
        return String.valueOf(tokenChars);
    }
}
