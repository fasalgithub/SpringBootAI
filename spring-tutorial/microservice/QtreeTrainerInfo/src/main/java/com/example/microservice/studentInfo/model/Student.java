package com.example.microservice.studentInfo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student
{
    private String studentName;
    private String courseInfo;
    private String trainerName;
    private Boolean isFeesPaid;
}
