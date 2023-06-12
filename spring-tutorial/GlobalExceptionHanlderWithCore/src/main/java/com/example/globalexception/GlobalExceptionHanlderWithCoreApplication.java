package com.example.globalexception;

import com.example.globalexception.myownexception.CoreException;
import com.example.globalexception.service.CoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlobalExceptionHanlderWithCoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GlobalExceptionHanlderWithCoreApplication.class, args);
	}

	@Override
	public void run(String... args){
		/*try {
			new CoreService().exceptionThrow();
		}
		catch (CoreException e){
			System.out.println(e);
		}*/
	}
}
