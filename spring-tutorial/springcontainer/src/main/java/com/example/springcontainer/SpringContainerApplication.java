package com.example.springcontainer;

import com.example.springcontainer.bean.Technology;
import com.example.springcontainer.bean.bank.account.access.BankBalance;
import com.example.springcontainer.bean.digital.account.access.DigitalBalance;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringContainerApplication
{
    public static void main(String[] args)
    {
        ConfigurableApplicationContext springContainer = SpringApplication.run(SpringContainerApplication.class, args);
        Technology  technology1 = springContainer.getBean(Technology.class);
        Technology  technology2 = springContainer.getBean(Technology.class);

        technology1.setLanguage("Java");
        technology2.setLanguage("Python");

        System.out.println(technology1.getLanguage());
    }


   /* @Bean
    @Qualifier("javaTech")
    public Technology javaTech() {
        Technology javaTech = new Technology();
        javaTech.setLanguage("java");
        return javaTech;
    }

    @Bean
    @Qualifier("pythonTech")
    public Technology pythonTech() {
        Technology pythonTech = new Technology();
        pythonTech.setLanguage("python");
        return pythonTech;
    }*/



}
