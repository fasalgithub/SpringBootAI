package com.example.globalexception.controller;


import com.example.globalexception.myownexception.CoreException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCoreControllerClass
{
    @GetMapping("/msg/{id}")
    public String getMyExceptionHandler(@PathVariable("id") int id){

        try {
            if(id>100) throw new CoreException("id should not exceed 100");
            return "hi :"+id;
        }catch (Exception e){
            System.out.println(" from try catch block");
        }

        return "hi";

    }
}
