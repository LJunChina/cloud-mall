package com.cloud.mall.usermicriservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@MapperScan(value = "com.cloud.mall.usermicriservice.dao")
@SpringBootTest
public class UserMicriserviceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
