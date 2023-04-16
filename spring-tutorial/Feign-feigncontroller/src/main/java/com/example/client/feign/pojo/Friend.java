package com.example.client.feign.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend
{
    private String studentName;
    private String studentMark;
    private String studentBranch;

}
