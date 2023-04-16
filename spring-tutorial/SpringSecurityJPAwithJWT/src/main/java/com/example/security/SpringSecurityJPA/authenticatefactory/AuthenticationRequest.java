package com.example.security.SpringSecurityJPA.authenticatefactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest
{
    private String userName;
    private String password;
}
