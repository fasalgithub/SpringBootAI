package com.example.spring.student.endpoints.loader;

import com.example.spring.student.endpoints.bean.Student;
import com.example.spring.student.endpoints.dao.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class StudentLoader {
    @Autowired
    private StudentRepo studentRepo;

    @PostConstruct
    public void loadStudents()
    {
        List<Student> students = List.of(
                new Student(1, "Sathya", "ECE", 100, "A+"),
                new Student(2, "Abi", "ECE", 90, null),
                new Student(3, "Arun", "ECE", 99, "AB+"),
                new Student(4, "Fasal", "ECE", 78, "AB-"),
                new Student(5, "Jaya", "AERO", 78, "B-"),
                new Student(6, "Kumar", "ECE", 78, "AB-"),
                new Student(7, "Swathi", "ECE", 78, "AB-"),
                new Student(8, "Monisha", "ECE", 98, "A-")

        );
        studentRepo.saveAll(students);
    }

    @PreDestroy
    public void closeStudentInfo() {
        studentRepo.deleteAll();
    }

}
