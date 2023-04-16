package com.example.springcontainer.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Learner {
    private String name;
    private String domain;
    @Autowired
    private Technology pythonTech;

    public Technology getTechnology() {
        return pythonTech;
    }
    public void setTechnology(Technology javaTech) {
        this.pythonTech = javaTech;
    }
    public Learner() {
        System.out.println("Object construction....");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public void study() {
        pythonTech.showMyLanguage();
    }
}
