package com.smartTech.dto.validation;

import com.smartTech.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;


public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
    @Autowired
    private UserDao userDao;

    @Override
    public void initialize(EmailConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!value.isEmpty()) {
            if (value.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                List<String> list = userDao.uniqueList("email");
                if (list.contains(value)) {
                    context.buildConstraintViolationWithTemplate("Someone already use this email.").addConstraintViolation();
                    return false;
                } else {
                    return true;
                }
            }else {
                context.buildConstraintViolationWithTemplate("Invalid Email.").addConstraintViolation();
                return false;
            }
        }
        context.buildConstraintViolationWithTemplate("Email can't be empty.").addConstraintViolation();
        return false;
    }
}
