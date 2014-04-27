/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.validator;

import com.szaki.dao.DerbyDao;
import com.szaki.domain.Login;
import java.util.List;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Dani
 */
public class LoginValidator implements Validator {

    private List<Login> listOfLogin;
    private DerbyDao dao = new DerbyDao();
    private boolean hasFound = false;

    @Override
    public boolean supports(Class clazz) {
        return Login.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Login login = (Login) target;

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/szakiDB;create=true");
        dataSource.setUsername("boss");
        dataSource.setPassword("omygod");

        //a dao adatforrásának megadása
        dao.setDataSource(dataSource);

        listOfLogin = dao.selectAllLogin();

        if (login.getEmail().isEmpty()) {
            errors.rejectValue("email", "required.email");
        }

        if (login.getEmail().isEmpty()) {
            errors.rejectValue("password", "required.password");
        }

        for (Login loginItem : listOfLogin) {
            if ((loginItem.getEmail().equals(login.getEmail())) && (loginItem.getPassword().equals(login.getPassword()))) {
                hasFound = true;
                break;
            }
        }
        if (hasFound == false) {
            errors.rejectValue("password", "wrong.login");
        }
    }

}
