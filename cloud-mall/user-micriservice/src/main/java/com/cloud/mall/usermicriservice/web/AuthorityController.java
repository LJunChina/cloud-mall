package com.cloud.mall.usermicriservice.web;

import com.alibaba.fastjson.JSONObject;
import com.cloud.mall.usermicriservice.dto.AuthorityReqDTO;
import com.cloud.mall.usermicriservice.dto.BaseRespDTO;
import com.cloud.mall.usermicriservice.enums.ResultCode;
import com.cloud.mall.usermicriservice.service.AuthorityService;
import com.cloud.mall.usermicriservice.utils.EmptyChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 权限API
 *
 * @author Jon_China
 * @create 2017/11/19
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthorityController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorityController.class);
    @Autowired
    private AuthorityService authorityService;

    /**
     * 保存权限信息
     * @param body
     * @return
     */
    @PostMapping(value = "/save-auth")
    public String saveAuthority(@RequestBody String body){
        logger.info("the params of saveAuthority is : {}",body);
        if(EmptyChecker.isEmpty(body)){
            return new BaseRespDTO(ResultCode.PARAMS_NOT_FOUND).toString();
        }
        try {
            AuthorityReqDTO request = JSONObject.parseObject(body,AuthorityReqDTO.class);
            BaseRespDTO baseRespDTO = this.authorityService.saveAuthority(request);
            String result = baseRespDTO.toString();
            logger.info("result of the saveAuthority is :{}",request);
            return result;
        }catch (Exception e){
            logger.error("exception occurred in saveAuthority",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }
}
