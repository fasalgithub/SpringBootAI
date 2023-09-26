package com.example.jaxb.jaxbmarshaller.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "Request")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@Data
public class Request
{
    private String requestId;
    private String requestName;
    private RequestAddress requestAddress;
}
