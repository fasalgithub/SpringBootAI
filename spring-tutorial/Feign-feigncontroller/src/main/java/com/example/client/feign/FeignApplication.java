package com.example.client.feign;

import com.example.client.feign.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@RestController
@RequestMapping("/feign")
@EnableEurekaClient
public class FeignApplication {

	@Autowired
	private FriendContact friendContact;

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}

    @GetMapping("/friends-zone")
	private List<Friend> groups(){
		return friendContact.group();
	}

}

@FeignClient(url = "http://localhost:7099/feign",name = "friends-group-client")
interface FriendContact
{
   @GetMapping("/friends")
   List<Friend> group();
}


