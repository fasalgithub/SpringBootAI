package com.example.microservice.studentInfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerInfo
{
    private String trainerId;
    private String trainerName;
    private List<Student> trainees;
}
