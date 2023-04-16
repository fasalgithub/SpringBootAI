package com.example.security.SpringSecurityJPA.controller;

import com.example.security.SpringSecurityJPA.authenticatefactory.AuthenticationRequest;
import com.example.security.SpringSecurityJPA.authenticatefactory.AuthenticationResponse;
import com.example.security.SpringSecurityJPA.dao.User;
import com.example.security.SpringSecurityJPA.repo.UserRepo;
import com.example.security.SpringSecurityJPA.service.MyUserDetails;
import com.example.security.SpringSecurityJPA.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SecurityController
{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(method = RequestMethod.GET,path = "/secret")
    public String welcomeAll()
    {
        return ("<h2> Welcome ADMIN </h2>");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest){

        /* user and password has to be authenticated*/
        String username = authenticationRequest.getUserName();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),authenticationRequest.getPassword()));
        }catch (BadCredentialsException e){
            System.out.println("invalid userName and password : "+e.getMessage());
        }

        /* get userDetails for that user */
        Optional<User> user =  userRepo.findByUserName(username);
        UserDetails userDetails =  user.map(MyUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User Not Found : "+username));

        /* generate JWT token */
        return ResponseEntity.ok(new AuthenticationResponse(jwtUtil.generateToken(userDetails)));

    }

}
