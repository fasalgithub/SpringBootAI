package com.example.eureka.service.QtreeEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class QtreeEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QtreeEurekaServerApplication.class, args);
	}

}
