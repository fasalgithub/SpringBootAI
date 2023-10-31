package com.usthealthproof.commons.starters.storage.core.validation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

public class AwsBucketEnablePropertyValidator implements Condition {
    private static final String ENV_AWS_BUCKET_ENABLED = "env.aws.bucket.enabled";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return (Objects.isNull(context.getEnvironment().getProperty(ENV_AWS_BUCKET_ENABLED, String.class)) ||
                (Objects.nonNull(context.getEnvironment().getProperty(ENV_AWS_BUCKET_ENABLED, String.class)) ?
                        context.getEnvironment().getProperty(ENV_AWS_BUCKET_ENABLED, String.class).matches("false") : Boolean.FALSE));
    }
}
