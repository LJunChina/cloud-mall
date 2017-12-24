package com.cloud.mall.usermicriservice.web;

import com.cloud.mall.usermicriservice.dto.BaseRespDTO;
import com.cloud.mall.usermicriservice.enums.ResultCode;
import com.cloud.mall.usermicriservice.service.SystemInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    private SystemInfoService systemInfoService;

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
            BaseRespDTO baseRespDTO = this.systemInfoService.getSystemInfoByName(systemName,pageIndex,pageSize);
            String result = baseRespDTO.toString();
            logger.info("result of the getSystemInfoByName is :{}",result);
            return result;
        }catch (Exception e){
            logger.error("exception occurred in getSystemInfoByName",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }

    /**
     * 保存业务系统信息接口
     * @param systemName
     * @param systemChn
     * @param systemHost
     * @param systemContext
     * @return
     */
    @PostMapping(value = "/save-system-info")
    public String saveSystemInfo(@RequestParam(value = "systemName",defaultValue = "")String systemName,
                                 @RequestParam(value = "systemChn",defaultValue = "")String systemChn,
                                 @RequestParam(value = "systemHost",defaultValue = "")String systemHost,
                                 @RequestParam(value = "systemContext",defaultValue = "")String systemContext,
                                 @RequestBody String body){
        logger.info("params of saveSystemInfo,systemName:{},systemChn:{},systemHost:{},systemContext:{}",systemName,systemChn,systemHost,systemContext);
        try {
            BaseRespDTO baseRespDTO = this.systemInfoService.saveSystemInfo(systemName,systemChn,systemHost,systemContext);
            String result = baseRespDTO.toString();
            logger.info("result of the saveSystemInfo is :{}",result);
            return result;
        }catch (Exception e){
            logger.error("exception occurred in saveSystemInfo",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }
}
