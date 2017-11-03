package com.cloud.mall.usermicriservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(value = "com.cloud.mall.usermicriservice.dao")
public class UserMicriserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicriserviceApplication.class, args);
	}
}
