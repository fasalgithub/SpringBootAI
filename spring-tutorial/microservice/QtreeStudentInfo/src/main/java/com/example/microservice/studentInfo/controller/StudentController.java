package com.example.microservice.studentInfo.controller;

import com.example.microservice.studentInfo.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
    @RequestMapping("/info")
    public List<Student> studentsInfo(){
       return List.of(
                new Student("Sathya", "Java Course", "Fasal", Boolean.TRUE),
                new Student("Abi", "Java Course", "Fasal", Boolean.TRUE),
                new Student("Riya", "Python Course", "Sharma", Boolean.FALSE),
                new Student("Kiruba", "Java Script Course", "Ganesh", Boolean.FALSE),
                new Student("Anu", "Java Course", "Sharvesh", Boolean.TRUE)
        );
    }
}
