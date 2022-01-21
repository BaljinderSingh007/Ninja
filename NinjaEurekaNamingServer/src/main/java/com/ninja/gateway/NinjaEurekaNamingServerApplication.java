package com.ninja.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NinjaEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NinjaEurekaNamingServerApplication.class, args);
	}

}
