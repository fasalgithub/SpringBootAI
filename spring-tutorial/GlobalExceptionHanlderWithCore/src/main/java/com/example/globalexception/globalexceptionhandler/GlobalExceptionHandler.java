package com.example.globalexception.globalexceptionhandler;

import com.example.globalexception.myownexception.CoreException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(CoreException.class)
    public void coreExceptionHandler(CoreException coreException){
        System.out.println(coreException.getMessage());
    }
}
