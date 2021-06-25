package com.example.demo;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = CheckUUIDValidator.class)

public @interface CheckUUID {
    String message() default "{UUID}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
