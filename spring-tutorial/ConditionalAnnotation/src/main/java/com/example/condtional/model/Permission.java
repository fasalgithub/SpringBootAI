package com.example.condtional.model;


import com.example.condtional.conditionalAnnotation.PropertyCondtional;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;



//@ConditionalOnProperty(value = "security.permission", havingValue = "true")
@Conditional(PropertyCondtional.class)
@Component
public class Permission
{
    public String getMyPermission()
    {
        return "Permission Granted";
    }
}
