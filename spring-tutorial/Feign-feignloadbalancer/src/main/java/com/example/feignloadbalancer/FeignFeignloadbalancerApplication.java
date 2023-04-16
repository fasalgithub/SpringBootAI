package com.example.feignloadbalancer;

import com.example.feignloadbalancer.pojo.Friend;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class FeignFeignloadbalancerApplication {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
    public static void main(String[] args) {
		SpringApplication.run(FeignFeignloadbalancerApplication.class, args);
	}


}

@RestController
@RibbonClient(name = "Friends-group-client",configuration = FriendLoadBalancedConfiguration.class)
class FriendController{
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/friends-group")
	public List<Friend> showListOfMyFriends() {
		List<Friend> friends = Arrays.asList(Objects.requireNonNull(this.restTemplate.getForObject("http://Friends-group-client/feign/friends", Friend[].class)));
		return friends;
	}
}

class FriendLoadBalancedConfiguration
{
	@Autowired
	IClientConfig ribbonClientConfig;

	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl();
	}

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new AvailabilityFilteringRule();
	}
}