package com.example.feigncontrollerpoints;

import com.example.feigncontrollerpoints.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@RestController
@RequestMapping("/server")
public class FeignFeigncontrollerpointsApplication {

	@Autowired
	private FriendController friendController;

	public static void main(String[] args) {
		SpringApplication.run(FeignFeigncontrollerpointsApplication.class, args);
	}

	@RequestMapping("/getToGather")
	private List<Friend> getToGather(){
		return friendController.getToGather();
	}
	@RequestMapping("/friend")
	private Friend friend(){
		return friendController.frn();
	}

}

@FeignClient(url = "http://localhost:7099/feign",name = "friends-group-client")
interface FriendController{

	@GetMapping("/friends")
	List<Friend> getToGather();

	@GetMapping("/friend")
	Friend frn();

}
