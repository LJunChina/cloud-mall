package com.cloud.mall.usermicriservice.web;

import com.alibaba.fastjson.JSONObject;
import com.cloud.mall.usermicriservice.dto.BaseRespDTO;
import com.cloud.mall.usermicriservice.dto.UserDetailRespDTO;
import com.cloud.mall.usermicriservice.dto.UserSearchRespDTO;
import com.cloud.mall.usermicriservice.enums.ResultCode;
import com.cloud.mall.usermicriservice.service.TokenService;
import com.cloud.mall.usermicriservice.service.UserService;
import com.cloud.mall.usermicriservice.utils.EmptyChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

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

    /**
     * 公钥获取
     * @return
     */
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

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping(value = "/get-user-list")
    public String getUserListByPage(@RequestParam(value = "message") String message){
        logger.info("the params of getUserListByPage is :{}",message);
        try {
            UserSearchRespDTO userSearchRespDTO = JSONObject.parseObject(message, UserSearchRespDTO.class);
            BaseRespDTO result = this.userService.getUserList(userSearchRespDTO);
            logger.info("this result of getUserListByPage is :{}",result.toString());
            return result.toString();
        }catch (Exception e){
            logger.error("exception occurred in getUserListByPage",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }

    /**
     * 用户详情查询
     * @param userId
     * @return
     */
    @GetMapping(value = "/get-user-detail/{userId}")
    public String getUserDetail(@PathVariable(value = "userId")  String userId){
        logger.info("the params of getUserDetail is :{}",userId);
        if (EmptyChecker.isEmpty(userId)) {
            return new BaseRespDTO(ResultCode.PARAMS_NOT_FOUND).toString();
        }
        try {
            UserDetailRespDTO result = this.userService.getUserInfo(userId);
            logger.info("this result of getUserDetail is :{}",result.toString());
            return result.toString();
        }catch (Exception e){
            logger.error("exception occurred in getUserDetail",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }

    /**
     * 检测用户是否登录
     * @param tokenId
     * @return
     */
    @GetMapping("/is-login/{tokenId}")
    public String getUserIsLogin(@PathVariable(value = "tokenId") String tokenId){
        if(EmptyChecker.isEmpty(tokenId)){
            return new BaseRespDTO(ResultCode.PARAMS_NOT_FOUND).toString();
        }
        logger.info("the params of getUserIsLogin is :{}",tokenId);
        try {
            BaseRespDTO baseRespDTO = this.tokenService.refreshTokenInfo(tokenId);
            String result = baseRespDTO.toString();
            logger.info("this result of getUserIsLogin is : {}" ,result);
            return result;
        }catch (Exception e){
            logger.error("exception occurred in getUserIsLogin :",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }
}
