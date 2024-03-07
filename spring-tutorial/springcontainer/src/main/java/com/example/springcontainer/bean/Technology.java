package com.example.springcontainer.bean;

import com.example.springcontainer.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Technology {
    private String language;

    @Autowired
    private Model model;

    Technology()
    {
        System.out.println("Object Created");
    }
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void printMyModel(){
        System.out.println(model.getModelName());
    }


}
