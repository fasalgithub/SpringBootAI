package com.example.springmvc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class AppApplication
{
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

//	@Bean
//	public InternalResourceViewResolver getViewResolver()
//	{
//		InternalResourceViewResolver resourceViewResolver= new InternalResourceViewResolver();
//		resourceViewResolver.setPrefix("/pages/");
//		resourceViewResolver.setSuffix(".jsp");
//		return resourceViewResolver;
//	}
}
