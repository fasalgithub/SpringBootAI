package com.example.spring.security.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.authentication.logout.DelegatingServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.SecurityContextServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.WebSessionServerLogoutHandler;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig
{
   /* @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

   /* @Bean
    public UserDetailsManager userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            manager.createUser(User.withUsername("Sathya").password(bCryptPasswordEncoder.encode("javascript")).roles("ADMIN").build());
        manager.createUser(User.withUsername("Abi").password(bCryptPasswordEncoder.encode("python")).roles("USER").build());
        return manager;
    }*/

   /* @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }*/

    /*@Bean
    public UserDetailsService users(){
        UserDetails user = User.builder().username("abi").password("pass").roles("USER").build();
        return new InMemoryUserDetailsManager(user);
    }*/

   /* @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {

        http.csrf().disable().authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and().httpBasic();
        http.formLogin();

        http.logout()
//                .addLogoutHandler(logoutHandler)
                .clearAuthentication(Boolean.TRUE)
                .invalidateHttpSession(Boolean.TRUE);
        return http.build();
    }*/



}
