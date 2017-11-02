package com.cloud.mall.ccmweb.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/login")
    public String login(){
        String result = this.restTemplate.getForEntity("http://user-micriservice/login",String.class).getBody();
        logger.info("this result is : {}" ,result);
        return "login";
    }
}
