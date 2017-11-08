package com.cloud.mall.ccmweb.web;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/user-login")
    public String login(@RequestParam(name = "userName")String userName, @RequestParam(name = "password")String password
            ,HttpServletResponse response){
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("userName",userName);
        params.add("password",password);
        String result = this.restTemplate.postForEntity("http://user-micriservice/login",params,String.class).getBody();
        logger.info("this result is : {}" ,result);
        JSONObject object = JSONObject.parseObject(result);
        if("0000".equals(object.getString("code"))){
            String tokenId = object.getString("data");
            Cookie cookie = new Cookie("tokenId",tokenId);
            cookie.setPath("/");
            cookie.setMaxAge(15*60);
            response.addCookie(cookie);
        }
        return result;
    }

    /**
     * 从服务器获取公钥
     * @return
     */
    @GetMapping("/get-public-key")
    public String getPublicKey(){
        String result = this.restTemplate.getForEntity("http://user-micriservice/get-public-key",String.class).getBody();
        logger.info("this result is : {}" ,result);
        return result;
    }
}
