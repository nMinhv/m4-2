package com.smartTech.dto.validation;

import com.smartTech.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class PhoneValidator implements ConstraintValidator<PhoneConstraint, String> {
    @Autowired
    UserDao userDao;

    @Override
    public void initialize(PhoneConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!value.isEmpty()) {
            if (value.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$")) {
                List<String> list = userDao.uniqueList("phone");
                if (list.contains(value)) {
                    context.buildConstraintViolationWithTemplate("Someone already use this phone number.").addConstraintViolation();
                    return false;
                } else {
                    return true;
                }
            }else {
                context.buildConstraintViolationWithTemplate("Invalid phone").addConstraintViolation();
                return false;
            }
        }
        context.buildConstraintViolationWithTemplate("Phone can't be empty.").addConstraintViolation();
        return false;
    }

}
