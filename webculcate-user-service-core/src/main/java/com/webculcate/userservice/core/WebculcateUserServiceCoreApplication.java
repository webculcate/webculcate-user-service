package com.webculcate.userservice.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WebculcateUserServiceCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebculcateUserServiceCoreApplication.class, args);
		// added one comment - 404
	}

}
