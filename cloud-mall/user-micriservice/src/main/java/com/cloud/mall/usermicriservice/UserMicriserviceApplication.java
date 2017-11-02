package com.cloud.mall.usermicriservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserMicriserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicriserviceApplication.class, args);
	}
}
