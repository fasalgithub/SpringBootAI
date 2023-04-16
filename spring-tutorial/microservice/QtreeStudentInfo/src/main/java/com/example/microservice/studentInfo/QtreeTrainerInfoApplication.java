package com.example.microservice.studentInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class QtreeTrainerInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(QtreeTrainerInfoApplication.class, args);
	}

}
