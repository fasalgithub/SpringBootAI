package com.example.springmvc.app.controller;

import com.example.springmvc.app.bean.User;
import com.example.springmvc.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FirstWebApp
{
    @Autowired
    UserService userService;

    @RequestMapping("/app-home")
    public String getMyApp()
    {
        return "app";
    }

    @RequestMapping("/login")
    public String getMyUser(User user)
    {
       return userService.addMyUser(user);
    }

    @RequestMapping("/get-my-all-user")
    @ResponseBody
    public List<User> getAllMyUser()
    {
        return userService.getAllMyUser();
    }

}

/*@RequestMapping("/login")
    public String getMyUser(HttpServletRequest request, HttpServletResponse response)
    {
       String id =  request.getParameter("id");
       String username =  request.getParameter("username");
       String tech =  request.getParameter("tech");

       HttpSession session = request.getSession();
       session.setAttribute("username",username);

       return "view";

    }


     @RequestMapping("/login")
    public ModelAndView getMyUser(User user)
    {
       ModelAndView mv = new ModelAndView();
       mv.setViewName("view");
       mv.addObject("user",user);
       return mv;
    }

    */