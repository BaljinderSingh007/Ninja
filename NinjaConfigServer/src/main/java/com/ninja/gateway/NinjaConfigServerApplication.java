package com.ninja.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class NinjaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NinjaConfigServerApplication.class, args);
	}

}
