package com.example.security.SpringSecurityJPA.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController
{
    @RequestMapping(method = RequestMethod.GET,path = "/welcome-all")
    public String welcomeAll()
    {
        return ("<h2> Welcome ALL </h2>");
    }
    @RequestMapping(method = RequestMethod.GET,path = "/welcome-user")
    public String welcomeUser()
    {
        return ("<h2> Welcome User </h2>");
    }
    @RequestMapping(method = RequestMethod.GET,path = "/welcome-admin")
    public String welcomeAdmin()
    {
        return ("<h2> Welcome Admin </h2>");
    }
}
