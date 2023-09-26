package com.example.jaxb.jaxbmarshaller.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAddress
{
    private String requestAddress;
    private List<String> subAddress;
}
