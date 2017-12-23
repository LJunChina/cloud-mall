package com.cloud.mall.usermicriservice.service;

import com.cloud.mall.usermicriservice.dto.BaseRespDTO;
import com.cloud.mall.usermicriservice.model.SystemInfo;

/**
 * 业务系统服务
 *
 * @author Jon_China
 * @create 2017/12/23
 */
public interface SystemInfoService {

    /**
     * 业务系统分页查询
     * @param systemName 业务系统名称
     * @param pageIndex  页号
     * @param pageSize 页大小
     * @return
     */
    BaseRespDTO getSystemInfoByName(String systemName,int pageIndex,int pageSize);

    /**
     * 保存业务系统
     * @param systemName
     * @param systemChn
     * @param systemHost
     * @param systemContext
     * @return
     */
    BaseRespDTO saveSystemInfo(String systemName,String systemChn,String systemHost,String systemContext);
}
