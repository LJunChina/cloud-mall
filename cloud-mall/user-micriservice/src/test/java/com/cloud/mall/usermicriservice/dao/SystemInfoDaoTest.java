package com.cloud.mall.usermicriservice.dao;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
import com.cloud.mall.usermicriservice.model.SystemInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.Assert.*;

public class SystemInfoDaoTest extends UserMicriserviceApplicationTests {
    @Autowired
    private ISystemInfoDao systemInfoDao;
    @Test
    public void getSystemInfoByName() throws Exception {
        PageInfo<SystemInfo> result = PageHelper
                .startPage(1,10)
                .doSelectPageInfo(() -> this.systemInfoDao.getSystemInfoByName("test"));
        Assert.assertEquals(1L,result.getTotal());
    }

    @Test
    public void saveSystemInfoTest(){
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setId(UUID.randomUUID().toString());
        systemInfo.setSystemChn("单元测试");
        systemInfo.setSystemContext("/junit");
        systemInfo.setSystemHost("127.0.0.1");
        systemInfo.setSystemName("junit");
        Assert.assertEquals(1,this.systemInfoDao.saveSystemInfo(systemInfo));
    }

}