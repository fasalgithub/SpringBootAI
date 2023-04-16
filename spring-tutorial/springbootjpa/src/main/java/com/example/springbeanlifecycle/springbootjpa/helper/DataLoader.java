package com.example.springbeanlifecycle.springbootjpa.helper;

import com.example.springbeanlifecycle.springbootjpa.bean.Student;
import com.example.springbeanlifecycle.springbootjpa.dao.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader
{
    //Bean Life
    @Autowired
    private StudentRepo studentRepo;

    @PostConstruct
    public void dataLoad()
    {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"Sathya","Settu","ECE",99));
        studentList.add(new Student(2,"Abi",null,"EEE",87));
        studentList.add(new Student(3,"Arun","Kumar","CSE",70));
        studentRepo.saveAll(studentList);
    }

    @PreDestroy
    public void dataDestroy()
    {
        studentRepo.deleteAll();
    }


}
