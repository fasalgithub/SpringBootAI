package com.example.condtional.conditionalAnnotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class PropertyCondtional implements Condition
{
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println(context.getEnvironment().getProperty("security.permission",String.class));
        return context.getEnvironment().getProperty("security.permission",String.class).matches("true");
    }
}
