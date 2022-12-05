package com.example.studyapp.Validator;

import com.example.studyapp.Validator.PasswordConstrain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstrain, String> {

    @Override
    public void initialize(PasswordConstrain contactNumber) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField != null && (contactField.length() >= 4) && (contactField.length() < 14);
    }

}