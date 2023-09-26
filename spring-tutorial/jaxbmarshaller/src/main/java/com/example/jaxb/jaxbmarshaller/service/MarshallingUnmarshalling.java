package com.example.jaxb.jaxbmarshaller.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.io.StringReader;
import java.io.StringWriter;

@Service
public class MarshallingUnmarshalling
{
    @Autowired
    public JAXBContext jaxbContext;

    public Object unMarshal(String apiRequestXmlMessage) {

        Object unMarshalledRequest = null;
        try {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unMarshalledRequest = unmarshaller.unmarshal(new StringReader(apiRequestXmlMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unMarshalledRequest;
    }

    public String marshal(String localPart, Class aClass,Object response) {
        String marshalledResponse = null;
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Optional: to format the XML output
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(convertToJAXBElement(localPart,aClass,response), stringWriter);
            marshalledResponse =  stringWriter.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marshalledResponse;
    }

    public static JAXBElement convertToJAXBElement(String localPart, Class aClass, Object o) {
        return new JAXBElement(new QName(localPart), aClass, o);
    }

}
