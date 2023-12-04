package com.smartTech.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

    @Override
    public void initialize(PasswordConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.isEmpty()){
            context.buildConstraintViolationWithTemplate("Password can't be empty");
            return false;
        }else {
            if(!value.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")){
                context.buildConstraintViolationWithTemplate("At least 8 character, 1 uppercase,1 number, 1 special").addConstraintViolation();
                return false;
            }else {
                return true;
            }
        }
    }
}
