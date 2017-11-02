package com.cloud.mall.mallserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MallServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallServerApplication.class, args);
	}
}
