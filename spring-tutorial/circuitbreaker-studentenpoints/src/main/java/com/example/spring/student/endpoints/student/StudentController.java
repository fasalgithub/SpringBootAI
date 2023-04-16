package com.example.spring.student.endpoints.student;

import com.example.spring.student.endpoints.bean.Student;
import com.example.spring.student.endpoints.dao.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class StudentController
{
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/students")
    private List<Student> students(){
        return this.myStudentDB();
    }

    private List<Student> myStudentDB()
    {
       return studentRepo.findAll();
    }

}


