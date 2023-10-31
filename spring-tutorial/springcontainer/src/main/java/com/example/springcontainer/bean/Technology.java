package com.example.springcontainer.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Technology {
    private String language;

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


}
