package com.example.spring.student.endpoints;

import com.example.spring.student.endpoints.bean.Student;
import com.example.spring.student.endpoints.dao.StudentPagingAndSorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class StudentJpaApplication implements CommandLineRunner
{
    /*@Autowired
    private StudentRepo studentRepo;*/
    @Autowired
    private StudentPagingAndSorting studentPagingAndSorting;

    public static void main(String[] args) {
        SpringApplication.run(StudentJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
		/*
		studentRepo.findStudentByStudentBranch("ECE").stream().forEach(System.out::println);
		studentRepo.findByMarkBetween(50,100).stream().forEach(System.out::println);
		studentRepo.findByBloodGroupNull().stream().forEach(System.out::println);
		studentRepo.findByStudentNameStartingWith("Aru").stream().forEach(System.out::println);
		*/


		/*

		studentRepo.retrieveStudentsByBloodGroup("AB-").stream().forEach(System.out::println);
		studentRepo.retrieveStudentsByMarks(90).stream().forEach(System.out::println);

		*/

//        studentRepo.getMyStudentByStudentNameAndStudentBranch("Sathya","ECE").forEach(System.out::println);
//        studentRepo.getBloodGroup().forEach(collectBloodGroupCount -> {
//            System.out.println(collectBloodGroupCount.getBloodGroup() + " : "+ collectBloodGroupCount.getBloodCount());
//        });

        //Update
//        studentRepo.updateStudentCount("Aravind",1);

       Page<Student> pages = studentPagingAndSorting.findAll(PageRequest.of(1,6).withSort(Sort.by("studentId").ascending()));
       System.out.println(pages.getTotalPages());
       System.out.println(pages.getTotalElements());
       System.out.println(pages.getNumber());
       pages.getContent().stream().forEach(System.out::println);


    }
}
