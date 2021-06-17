package com.example.demo;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;
import java.util.regex.Pattern;

@Component
public class CheckUUIDValidator implements ConstraintValidator<CheckUUID, String> {

    private final static Pattern UUID_REGEX_PATTERN =
            Pattern.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        return UUID_REGEX_PATTERN.matcher(s).matches();
    }
}
