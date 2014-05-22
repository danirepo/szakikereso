/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.controller;

import com.szaki.dao.DerbyDao;
import com.szaki.domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Dani
 */
public class UserRegistrationController extends SimpleFormController {

    public UserRegistrationController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(User.class);
        setCommandName("userRegistration");
        setSuccessView("userRegistrationSuccessView");
        setFormView("userRegistrationView");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Object command, BindException errors) throws Exception {
        DerbyDao dao = new DerbyDao();
        // Initialize the datasource, could /should be done of Spring
        // configuration
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/szakiDB;create=true");
        dataSource.setUsername("boss");
        dataSource.setPassword("omygod");
        // Inject the datasource into the dao
        dao.setDataSource(dataSource);

        User user = (User) command;
//        System.out.println(user.getFirstName() + "," + user.getLastName() + "," + user.getEmail() + "," + user.getPassword());
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        String password = md5.encodePassword(user.getPassword(), null);
        dao.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), password);

        ModelAndView mv = new ModelAndView(getSuccessView());

        return mv;
    }

}
