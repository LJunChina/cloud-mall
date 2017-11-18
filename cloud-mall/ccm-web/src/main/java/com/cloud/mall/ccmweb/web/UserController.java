package com.cloud.mall.ccmweb.web;

import com.alibaba.fastjson.JSONObject;
import com.cloud.mall.ccmweb.dto.BaseRespDTO;
import com.cloud.mall.ccmweb.enums.ResultCode;
import com.cloud.mall.ccmweb.utils.Constant;
import com.cloud.mall.ccmweb.utils.ControllerUtil;
import com.cloud.mall.ccmweb.utils.EmptyChecker;
import com.google.code.kaptcha.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 用户登录
     * @param userName
     * @param password
     * @param response
     * @param code
     * @return
     */
    @PostMapping(value = "/user-login")
    public String login(@RequestParam(name = "userName")String userName, @RequestParam(name = "password")String password
            , HttpServletResponse response, @RequestParam(name = "code") String code, HttpSession session){
        String sessionCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(sessionCode == null || !sessionCode.equals(code)){
            return new BaseRespDTO(ResultCode.INVALID_CODE).toString();
        }
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("userName",userName);
        params.add("password",password);
        String result = this.restTemplate.postForEntity(Constant.USER_LOGIN,params,String.class).getBody();
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
        String result = this.restTemplate.getForEntity(Constant.GET_PUBLIC_KEY,String.class).getBody();
        logger.info("this result is : {}" ,result);
        return result;
    }

    /**
     * 用户详情查询
     * @param userId
     * @return
     */
    @GetMapping("/get-user-detail/{userId}")
    public String getUserDetailById(@PathVariable(value = "userId") String userId){
        String result = this.restTemplate.getForEntity(Constant.GET_USER_INFO_BY_ID,String.class,userId).getBody();
        logger.info("this result is : {}" ,result);
        return result;
    }

    /**
     * 用户列表分页查询
     * @param request
     * @return
     */
    @GetMapping("/get-user-list")
    public String getUserList(HttpServletRequest request){
        Map<String,String> resultMap = ControllerUtil.getParamtersMap(request);
        String params = JSONObject.toJSONString(resultMap);
        logger.info("the params of [get-user-list] is :{}",params);
        String result = this.restTemplate.getForEntity(Constant.GET_USER_LIST,String.class,params).getBody();
        logger.info("this result is : {}" ,result);
        return result;
    }
}
