package com.example.security.SpringSecurityJPA.authenticatefactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse
{
  private String jwt;
}
