package com.cloud.mall.usermicriservice.dao;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
import com.cloud.mall.usermicriservice.dto.AuthorityReqDTO;
import com.cloud.mall.usermicriservice.enums.YesOrNoEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * AuthorityDao测试类
 *
 * @author Jon_China
 * @create 2017/11/18
 */
public class AuthorityDaoTest extends UserMicriserviceApplicationTests {

    @Autowired
    private IAuthorityDao authorityDao;

    @Test
    public void testAddAuthority(){
        AuthorityReqDTO authority = new AuthorityReqDTO();
        authority.setId(UUID.randomUUID().toString());
        authority.setName("用户管理1");
        authority.setAvailable(YesOrNoEnum.YES.getCode());
        authority.setIcon("phone");
        authority.setParentId("0");
        authority.setSortNum(1);
        authority.setStyle("large");
        authority.setAppName("cloud_mall");
        Assert.assertEquals(1,this.authorityDao.addAuthority(authority));
    }

    @Test
    public void testGetAllAuthorities(){
        AuthorityReqDTO reqDTO = new AuthorityReqDTO();
        reqDTO.setAppName("cloud_mall");
        Assert.assertNotNull(this.authorityDao.getAllAuthorities(reqDTO));
    }
}
