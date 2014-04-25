/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.validator;

import com.szaki.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Dani
 */
public class UserValidator implements Validator {

    private EmailValidator emailValidator = new EmailValidator();
    private final static int MIN_PASSWORD = 6;

    @Override
    public boolean supports(Class clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;

        if (user.getLastName().isEmpty()) {
            errors.rejectValue("lastName", "required.lastName");
        }

        if (user.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "required.firstName");
        }

        if (user.getEmail().isEmpty()) {
            errors.rejectValue("email", "required.email");
        }

        if ((emailValidator.validate(user.getEmail())) == false) {
            errors.rejectValue("email", "invalid.email");
        }

        if (user.getPassword().isEmpty() || user.getPassword2().isEmpty()) {
            errors.rejectValue("password", "required.password");
        }

        if (!(user.getPassword().equals(user.getPassword2()))) {
            errors.rejectValue("password", "notequals.password");
        }

        if (user.getPassword().length() < MIN_PASSWORD || user.getPassword2().length() < MIN_PASSWORD) {
            errors.rejectValue("password", "short.password");
        }
    }

}
