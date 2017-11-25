package com.cloud.mall.ccmweb.web;

import com.alibaba.fastjson.JSONObject;
import com.cloud.mall.ccmweb.dto.BaseRespDTO;
import com.cloud.mall.ccmweb.enums.ResultCode;
import com.cloud.mall.ccmweb.enums.YesOrNoEnum;
import com.cloud.mall.ccmweb.utils.Constant;
import com.cloud.mall.ccmweb.utils.ControllerUtil;
import com.cloud.mall.ccmweb.utils.EmptyChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    private RestTemplate restTemplate;

    /**
     * 增加操作(权限信息)
     * @param request
     * @return
     */
    @PostMapping(value = "/save-auth")
    public String saveAuthority(HttpServletRequest request){
        Map<String,String> params = ControllerUtil.getParamtersMap(request);
        logger.info("the params of saveAuthority is : {}",params);
        try {
            if(EmptyChecker.notEmpty(params.get("available")) && params.get("available").equals("on")){
                params.put("available", YesOrNoEnum.YES.getCode());
            }else {
                params.put("available",YesOrNoEnum.NO.getCode());
            }
            params.put("appName","cloud_mall");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            HttpEntity httpEntity = new HttpEntity(JSONObject.toJSONString(params),headers);
            String result = this.restTemplate.postForEntity(Constant.SAVE_AUTHORITY,httpEntity,String.class).getBody();
            logger.info("result of the saveAuthority is :{}",result);
            return result;
        }catch (Exception e){
            logger.error("exception occurred in saveAuthority",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }

    /**
     * 获取系统菜单
     * @return
     */
    @GetMapping(value = "/get-all-menus")
    public String getAllMenus(){
        try {
            String result = this.restTemplate.getForEntity(Constant.GET_ALL_MENUS,String.class,"cloud_mall").getBody();
            logger.info("result of the getAllMenus is :{}",result);
            return result;
        }catch (Exception e){
            logger.error("exception occurred in getAllMenus",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }
}
