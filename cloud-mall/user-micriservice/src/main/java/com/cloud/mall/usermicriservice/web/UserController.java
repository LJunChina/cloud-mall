package com.cloud.mall.usermicriservice.web;

import com.cloud.mall.usermicriservice.dto.BaseRespDTO;
import com.cloud.mall.usermicriservice.enums.ResultCode;
import com.cloud.mall.usermicriservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public String login(@RequestParam(name = "userName")String userName, @RequestParam(name = "password")String password){
        logger.info("the params for login userName:{},password:{}",userName,password);
        try {
            BaseRespDTO result = this.userService.userLogin(userName,password);
            logger.info("the result of user login is :{}",result.toString());
            return result.toString();
        }catch (Exception e){
            logger.error("exception occurred in login",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }

    @GetMapping(value = "/get-public-key")
    public String getPublicKey(){
        try {
            BaseRespDTO result = this.userService.getPublicKey();
            logger.info("this result of getPublicKey is :{}",result.toString());
            return result.toString();
        }catch (Exception e){
            logger.error("exception occurred in getPublicKey",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }
}
