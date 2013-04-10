package com.supinfo.rmt.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
public class CheckPasswordConstraint implements ConstraintValidator<CheckPassword, String> {
    @Override
    public void initialize(CheckPassword checkPassword) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("[a-z]+") && s.matches("[A-Z]+") && s.matches("[0-9]+");
    }
}
