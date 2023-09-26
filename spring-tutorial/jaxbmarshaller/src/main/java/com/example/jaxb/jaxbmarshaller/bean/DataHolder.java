package com.example.jaxb.jaxbmarshaller.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;



@Getter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DataHolder")
@JsonIgnoreProperties
public class DataHolder {
    private Map<String, Object> dataMap;

    public void addData(String key, Object value) {
        if(null == dataMap) {
            dataMap = new HashMap<>();
        }
        dataMap.put(key, value);
    }

    public void addAllData(Map<String,Object> newDataMap){
        if(null == dataMap){
            dataMap = newDataMap;
        }
        dataMap.putAll(newDataMap);
    }

    public Object getData(String key) {
        if(CollectionUtils.isEmpty(dataMap)) {
            return null;
        }
        return dataMap.get(key);
    }

    public void removeData(String key) {
        if(!CollectionUtils.isEmpty(dataMap)) {
            dataMap.remove(key);
        }
    }

    public void clearData() {
        if(!CollectionUtils.isEmpty(dataMap)) {
            dataMap.clear();
        }
    }

    public Map<String,Object> getAllData(){
        if(null == dataMap) {
            dataMap = new HashMap<>();
        }
        return dataMap;
    }

    @Override
    public String toString() {
        return "DataHolder{" +
                "dataMap=" + dataMap +
                '}';
    }
}
