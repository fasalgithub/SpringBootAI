package com.example.springcontainer.bean;

import com.example.springcontainer.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Learner {
    private String name ="Java";
    private String domain;
//    @Autowired
//    private Technology pythonTech;
//
//    public Technology getTechnology() {
//        return pythonTech;
//    }
//
//    public void setTechnology(Technology javaTech) {
//        this.pythonTech = javaTech;
//    }
//
//    public Learner() {
//        System.out.println("Object construction....");
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDomain() {
//        return domain;
//    }
//
//    public void setDomain(String domain) {
//        this.domain = domain;
//    }
//    /* public void study() {
//        pythonTech.showMyLanguage();
//    }*/

    @Bean
    public Model setModel() {
        Model model = new Model();
        model.setModelName(name);
        return model;
    }
}
