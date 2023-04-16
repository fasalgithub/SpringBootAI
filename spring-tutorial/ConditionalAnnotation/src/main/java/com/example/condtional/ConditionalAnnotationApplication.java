package com.example.condtional;

import com.example.condtional.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConditionalAnnotationApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(ConditionalAnnotationApplication.class, args);
	}

}

@RestController
@ConditionalOnBean(Permission.class)
class ConditionalController
{
	@Autowired(required = false)
	private Permission permission;

	@RequestMapping("/permission")
 	public String getMyPermission()
	{
		return permission.getMyPermission();
	}

}
