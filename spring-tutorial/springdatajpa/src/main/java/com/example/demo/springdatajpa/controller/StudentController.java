package com.example.demo.springdatajpa.controller;


import com.example.demo.springdatajpa.dao.Student;
import com.example.demo.springdatajpa.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController
{
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/message")
    public String getMyMessage(){
        return "Hello JPA";
    }

    @GetMapping("/get-student")
    public Student mySampleReference()
    {
        Student student = new Student(101,"Jasn","sddsdsd");
        return student;
    }
    @GetMapping("/get-all-my-students")
    public List<Student> getAllMyStudents()
    {
     return studentRepo.findAll();
    }
    @GetMapping("/get-all-my-student/{id}")
    public Student getAllMyStudents(@PathVariable("id") Integer studentId)
    {
       Optional<Student> student =  studentRepo.findById(studentId);
       if(student.isPresent()) return student.get();
       else return new Student();
    }
    @PostMapping("/load-my-student")
    public Student addMyStudent(@RequestBody Student student)
    {
        studentRepo.save(student);
        return student;
    }
    @DeleteMapping("/delete-my-student/{id}")
    public String deleteMyStudent(@PathVariable("id") Integer studentId)
    {
        studentRepo.deleteById(studentId);
        return "Student Removed";
    }

}
