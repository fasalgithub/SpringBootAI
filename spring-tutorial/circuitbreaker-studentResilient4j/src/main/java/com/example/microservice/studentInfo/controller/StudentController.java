package com.example.microservice.studentInfo.controller;

import com.example.microservice.studentInfo.model.Student;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final String STUDENT_DB = "http://localhost:9988/students";
    private static final String STUDENT_SERVICE = "studentService";


    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @RequestMapping("/info")
    @CircuitBreaker(name=STUDENT_SERVICE,fallbackMethod = "defaultStudentsInfo")
    public List<Student> students() {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(STUDENT_DB, Student[].class)));
    }

    public List<Student> defaultStudentsInfo(Throwable t)
    {
        return Stream.of(
                new Student(101, "Sathya", "ECE", 100, "A+"),
                new Student(102, "Abi", "ECE", 90, null),
                new Student(103, "Arun", "ECE", 99, "AB+"),
                new Student(104, "Fasal", "ECE", 78, "AB-"),
                new Student(105, "Jaya", "AERO", 78, "B-")
        ).collect(Collectors.toList());
    }


}
