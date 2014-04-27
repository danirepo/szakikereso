/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.validator;

import com.szaki.dao.DerbyDao;
import com.szaki.domain.Login;
import com.szaki.domain.User;
import java.util.List;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Dani
 */
public class UserValidator implements Validator {

    private EmailValidator emailValidator = new EmailValidator();
    private final static int MIN_PASSWORD = 6;
    private List<Login> listOfLogin;
    DerbyDao dao = new DerbyDao();

    @Override
    public boolean supports(Class clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/szakiDB;create=true");
        dataSource.setUsername("boss");
        dataSource.setPassword("omygod");

        //a dao adatforrásának megadása
        dao.setDataSource(dataSource);

        listOfLogin = dao.selectAllLogin();

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

        if (!(user.getEmail().isEmpty()) && (emailValidator.validate(user.getEmail()))) {
            for (Login loginItem : listOfLogin) {
                if (loginItem.getEmail().equals(user.getEmail())) {
                    errors.rejectValue("email", "used.email");
                    break;
                }
            }
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
