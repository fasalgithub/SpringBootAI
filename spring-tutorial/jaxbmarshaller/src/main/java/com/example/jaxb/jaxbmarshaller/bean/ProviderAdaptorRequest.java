package com.example.jaxb.jaxbmarshaller.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ProviderAdaptorRequest")
@JsonIgnoreProperties
@Setter
@Data
public class ProviderAdaptorRequest {

    @XmlElement(name = "commit",required = true)
    private boolean commit;
    @XmlElement(name = "connectionMode",required = true)
    private ConnectionMode connectionMode;
    @XmlElement(name = "headers")
    private DataHolder headers;
    @XmlElement(name = "payLoad", required = true)
    private ProviderMaintenanceServiceIBRequestRoot payLoad;

}
