package com.example.jaxb.jaxbmarshaller.service;

import com.example.jaxb.jaxbmarshaller.dao.InstrumentationAgent;
import org.springframework.stereotype.Service;

@Service
public class ObjectMemoryManagement {
    public void printObjectSize(Object object){
        System.out.println("Object type: " + object.getClass() +
                ", size: " + InstrumentationAgent.getObjectSize(object) + " bytes");
    }
}
