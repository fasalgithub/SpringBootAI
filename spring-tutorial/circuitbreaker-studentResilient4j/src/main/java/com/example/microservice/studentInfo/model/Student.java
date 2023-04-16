package com.example.microservice.studentInfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student
{

    private Integer studentId;
    private String studentName;
    private String studentBranch;
    private int mark;
    private String bloodGroup;

}
