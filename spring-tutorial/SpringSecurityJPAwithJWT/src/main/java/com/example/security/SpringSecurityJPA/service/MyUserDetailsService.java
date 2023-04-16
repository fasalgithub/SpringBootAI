package com.example.security.SpringSecurityJPA.service;

import com.example.security.SpringSecurityJPA.dao.User;
import com.example.security.SpringSecurityJPA.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.Objects;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
       Optional<User> user =  userRepo.findByUserName(username);
       return user.map(MyUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User Not Found : "+username));
    }
}
