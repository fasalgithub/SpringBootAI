package com.example.demo.springdatajpa.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_TABLE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_ID",length = 30)
    private int studentId;
    @Column(name = "STUDENT_NAME",unique = true)
    private String studentName;
    @Column(name = "STUDENT_BATCH",unique = true)
    private String studentBatch;

}
