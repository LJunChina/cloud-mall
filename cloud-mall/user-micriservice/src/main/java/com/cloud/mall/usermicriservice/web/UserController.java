package com.cloud.mall.usermicriservice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping(value = "/login")
    public String login(){
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/login,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
        return "login is provider";
    }
}
