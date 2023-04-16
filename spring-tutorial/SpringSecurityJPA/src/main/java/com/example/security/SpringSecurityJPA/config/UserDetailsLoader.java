package com.example.security.SpringSecurityJPA.config;

import com.example.security.SpringSecurityJPA.dao.User;
import com.example.security.SpringSecurityJPA.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class UserDetailsLoader {

    @Autowired
    private UserRepo userRepo;


    @PostConstruct
    public void UserDetailsLoader()
    {
       List<User> users =  List.of(
                new User(1, "Sathya", "pass", "ROLE_USER", Boolean.TRUE),
                new User(2, "Abi", "admin", "ROLE_USER,ROLE_ADMIN", Boolean.TRUE),
                new User(3, "Fasal", "user", "ROLE_USER", Boolean.FALSE)
        );
        userRepo.saveAll(users);
    }

}
