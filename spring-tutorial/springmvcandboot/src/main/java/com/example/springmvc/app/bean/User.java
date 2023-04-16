package com.example.springmvc.app.bean;

public class User
{
    private String id;
    private String userName;
    private String tech;

    public User()
    {

    }
    public User(String id, String userName, String tech) {
        this.id = id;
        this.userName = userName;
        this.tech = tech;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
