package com.cloud.mall.ccmweb.web;

import com.cloud.mall.ccmweb.dto.BaseRespDTO;
import com.cloud.mall.ccmweb.enums.ResultCode;
import com.cloud.mall.ccmweb.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * 系统角色API
 *
 * @author Jon_China
 * @create 2017/11/18
 */
@RestController
@RequestMapping(value = "/role")
public class RoleInfoController {

    private static final Logger logger = LoggerFactory.getLogger(RoleInfoController.class);
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 新增角色信息
     * @param roleName
     * @return
     */
    @PostMapping(value = "/save-role")
    public String saveRoleInfo(@RequestParam(value = "roleName",defaultValue = "") String roleName){
        logger.info("the params of saveRoleInfo is : {} ",roleName);
        try {
            MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
            params.add("roleName",roleName);
            String result = this.restTemplate.postForEntity(Constant.SAVE_ROLE_INFO,params,String.class).getBody();
            logger.info("the result of saveRoleInfo is : {}",result);
            return result;
        }catch (Exception e){
            logger.error("exception occurred in saveRoleInfo",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }
}
