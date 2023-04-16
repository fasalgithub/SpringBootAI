package com.example.spring.student.endpoints;

import com.example.spring.student.endpoints.bean.Student;
import com.example.spring.student.endpoints.dao.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class StudentJpaApplication
{
    public static void main(String[] args) {
        SpringApplication.run(StudentJpaApplication.class, args);
    }

}
