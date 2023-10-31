package com.example.spring.student.endpoints.dbservice;

import org.springframework.stereotype.Service;

@Service
public interface CollectBranchCount
{
    String getStudentBranchName();
    Long getBranchCount();
}
