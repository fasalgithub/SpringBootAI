package com.example.spring.demo.config.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("db")
public class DbCredentialTest
{
    private String url;
    private String port;
    private String username;
    private String password;
    private String domain;
}
