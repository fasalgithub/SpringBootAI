package com.example.jaxb.jaxbmarshaller.config;

import com.example.jaxb.jaxbmarshaller.bean.ProviderAdaptorRequest;
import com.example.jaxb.jaxbmarshaller.bean.ProviderMaintenanceServiceIBRequestRoot;
import com.example.jaxb.jaxbmarshaller.bean.Request;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarshallingUnMarshallingConfig
{
    @Bean
    public JAXBContext jaxbContext() throws JAXBException {
      return JAXBContext.newInstance(Request.class, ProviderAdaptorRequest.class, ProviderMaintenanceServiceIBRequestRoot.class);
    }
}
