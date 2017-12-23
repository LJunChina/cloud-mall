package com.cloud.mall.usermicriservice.dao;

import com.cloud.mall.usermicriservice.model.SystemInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository(value = "systemInfoDao")
public interface ISystemInfoDao {
    /**
     * 根据系统名称查询
     * @param systemName
     * @return
     */
    List<SystemInfo> getSystemInfoByName(@Param(value = "name") String systemName);
}
