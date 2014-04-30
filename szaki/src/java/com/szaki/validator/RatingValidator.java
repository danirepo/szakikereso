/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.validator;

import com.szaki.domain.Rating;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Dani
 */
public class RatingValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return Rating.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Rating rating = (Rating) target;

        if (rating.getDescription().isEmpty()) {
            errors.rejectValue("description", "required.description");
        }

    }

}
