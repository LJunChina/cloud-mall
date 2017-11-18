package com.cloud.mall.usermicriservice.dao;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
import com.cloud.mall.usermicriservice.model.RoleInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * RuleInfoDao 测试类
 *
 * @author Jon_China
 * @create 2017/11/18
 */
public class RoleInfoDaoTest extends UserMicriserviceApplicationTests {

    @Autowired
    private IRoleInfoDao roleInfoDao;

    @Test
    public void testAddRoleInfo(){
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setId(UUID.randomUUID().toString());
        roleInfo.setRoleName("项目经理");
        Assert.assertEquals(1,this.roleInfoDao.addRoleInfo(roleInfo));
    }
}
