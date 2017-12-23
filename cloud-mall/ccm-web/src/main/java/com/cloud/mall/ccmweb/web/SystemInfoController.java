package com.cloud.mall.ccmweb.web;

import com.alibaba.fastjson.JSONObject;
import com.cloud.mall.ccmweb.dto.BaseRespDTO;
import com.cloud.mall.ccmweb.enums.ResultCode;
import com.cloud.mall.ccmweb.utils.Constant;
import com.cloud.mall.ccmweb.utils.ControllerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * 业务系统管理API
 *
 * @author Jon_China
 * @create 2017/12/23
 */
@RestController
@RequestMapping(value = "/system-info")
public class SystemInfoController {

    private static final Logger logger = LoggerFactory.getLogger(SystemInfoController.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 业务系统分页查询
     * @param systemName
     * @param pageSize
     * @param pageIndex
     * @return
     */
    @GetMapping(value = "/get-system-info")
    public String getSystemInfoByName(@RequestParam(value = "systemName",defaultValue = "")String systemName,
                                      @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                      @RequestParam(value = "pageIndex",defaultValue = "1") int pageIndex){
        logger.info("params of getSystemInfoByName,systemName : {},pageSize:{},pageIndex:{}",systemName,pageSize,pageIndex);
        try {
            String result = this.restTemplate.getForEntity(Constant.GET_SYSTEM_INFO_BY_NAME,String.class,systemName,pageSize,pageIndex).getBody();
            logger.info("result of the getSystemInfoByName is :{}",result);
            return result;
        }catch (Exception e){
            logger.error("exception occurred in getSystemInfoByName",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }

    /**
     * 保存业务系统信息接口
     * @param request
     * @return
     */
    @PostMapping(value = "/save-system-info")
    public String saveSystemInfo(HttpServletRequest request){
        Map<String,String> params = ControllerUtil.getParamtersMap(request);
        String param = JSONObject.toJSONString(params);
        logger.info("params of saveSystemInfo :{}",param);
        try {
            String result = this.restTemplate.postForEntity(Constant.SAVE_SYSTEM_INFO,param,String.class).getBody();
            logger.info("result of the saveSystemInfo is :{}",result);
            return result;
        }catch (Exception e){
            logger.error("exception occurred in saveSystemInfo",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }
}
