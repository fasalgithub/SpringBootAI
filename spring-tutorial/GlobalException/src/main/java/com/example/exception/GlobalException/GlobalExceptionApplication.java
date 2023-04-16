package com.example.exception.GlobalException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlobalExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalExceptionApplication.class, args);
	}

}

//@ControllerAdvice - Handles Exception Globally
//@ExceptionHandler
//@ResponseStatus
//@ResponseEntity
//ResponseEntityExceptionHandler



