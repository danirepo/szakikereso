/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.validator;

import com.szaki.domain.Szaki;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Dani
 */
public class SzakiValidator implements Validator {

    private EmailValidator emailValidator = new EmailValidator();
    private final static int MIN_PASSWORD = 6;
    private final static int MAX_PROFESSION = 5;

    @Override
    public boolean supports(Class clazz) {
        return Szaki.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Szaki szaki = (Szaki) target;

        if (szaki.getLastName().isEmpty()) {
            errors.rejectValue("lastName", "required.lastName");
        }

        if (szaki.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "required.firstName");
        }

        if (szaki.getNameOfCompany().isEmpty()) {
            errors.rejectValue("nameOfCompany", "required.nameOfCompany");
        }

        if (szaki.getEmail().isEmpty()) {
            errors.rejectValue("email", "required.email");
        }

        if (!(emailValidator.validate(szaki.getEmail()))) {
            errors.rejectValue("email", "invalid.email");
        }

        if (szaki.getPhone().isEmpty()) {
            errors.rejectValue("phone", "required.phone");
        }

        try {
            if (szaki.getProfession().isEmpty()) {
                errors.rejectValue("profession", "required.profession");
            }

            if (szaki.getProfession().length() > MAX_PROFESSION) {
                errors.rejectValue("profession", "much.profession");
            }
        } catch (Exception e) {
            errors.rejectValue("profession", "required.profession");
        }

        if (szaki.getCountry().isEmpty()) {
            errors.rejectValue("country", "required.country");
        }

        if (szaki.getCounty().isEmpty()) {
            errors.rejectValue("county", "required.county");
        }

        if (szaki.getCity().isEmpty()) {
            errors.rejectValue("city", "required.city");
        }

        if (szaki.getStreet().isEmpty()) {
            errors.rejectValue("street", "required.street");
        }

        if (szaki.getNumber().isEmpty()) {
            errors.rejectValue("number", "required.number");
        }

        if (szaki.getPassword().isEmpty() || szaki.getPassword2().isEmpty()) {
            errors.rejectValue("password", "required.password");
        }

        if (!(szaki.getPassword().equals(szaki.getPassword2()))) {
            errors.rejectValue("password", "notequals.password");
        }

        if (szaki.getPassword().length() < MIN_PASSWORD || szaki.getPassword2().length() < MIN_PASSWORD) {
            errors.rejectValue("password", "short.password");
        }
    }

}
