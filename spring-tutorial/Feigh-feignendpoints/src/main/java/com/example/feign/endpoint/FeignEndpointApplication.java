package com.example.feign.endpoint;

import com.example.feign.endpoint.pojo.Friend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
@RequestMapping("/feign")
//@EnableEurekaClient
public class FeignEndpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignEndpointApplication.class, args);
	}

	@RequestMapping("/friends")
    private List<Friend> showMyFriendsList(){
		return Arrays.asList(
				new Friend("Sathya","55","ECE"),
				new Friend("Abi","65","EEE"),
				new Friend("Fasal","75","ECE")
		);
	}
	@RequestMapping("/friend")
	private Friend showMyFriend(){
		return new Friend("Riya","99","CSE");
	}



}
