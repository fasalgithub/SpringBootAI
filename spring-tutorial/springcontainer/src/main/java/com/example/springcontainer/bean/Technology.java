package com.example.springcontainer.bean;

import org.springframework.stereotype.Component;

public class Technology {
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void showMyLanguage() {
        System.out.println(language);
    }
}
