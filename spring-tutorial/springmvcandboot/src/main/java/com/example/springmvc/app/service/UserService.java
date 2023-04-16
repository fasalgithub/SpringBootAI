package com.example.springmvc.app.service;

import com.example.springmvc.app.bean.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    static List<User> listOfUser = new ArrayList<>();
    static
    {
        listOfUser.add(new User("101","Sathya","Java"));
        listOfUser.add(new User("102","Fasal","Python"));
        listOfUser.add(new User("103","Abi","JavaScript"));
    }
    public List<User> getAllMyUser()
    {
        return listOfUser;
    }

    public String addMyUser(User user)
    {
        listOfUser.add(user);
        return "User added";
    }
}
