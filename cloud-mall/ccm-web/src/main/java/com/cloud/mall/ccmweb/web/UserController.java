package com.cloud.mall.ccmweb.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/login")
    public String login(@RequestParam(name = "userName")String userName, @RequestParam(name = "password")String password){
        Map<String,String> params = new HashMap<>();
        params.put("userName",userName);
        params.put("password",password);
        String result = this.restTemplate.getForEntity("http://user-micriservice/login?userName={userName}&password={password}",String.class,params).getBody();
        logger.info("this result is : {}" ,result);
        return "login";
    }
}
