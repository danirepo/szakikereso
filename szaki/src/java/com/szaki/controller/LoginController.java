/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.controller;

import com.szaki.dao.DerbyDao;
import com.szaki.domain.Login;
import com.szaki.domain.Szaki;
import com.szaki.domain.User;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Dani
 */
@SessionAttributes("loggedUser")
public class LoginController extends SimpleFormController {

    private DerbyDao dao = new DerbyDao();

    public LoginController() {
        //Initialize controller properties here or 
        //in the Web Application Context
        setCommandClass(Login.class);
        setCommandName("loginCN");
        setSuccessView("loginSuccessView");
        setFormView("loginView");
    }

    /*@Override
     protected void doSubmitAction(Object command) throws Exception {
     throw new UnsupportedOperationException("Not yet implemented");
     }*/
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Object command, BindException errors) throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/szakiDB;create=true");
        dataSource.setUsername("boss");
        dataSource.setPassword("omygod");

        //a dao adatforrásának megadása
        dao.setDataSource(dataSource);

        Login login = (Login) command;
        String email = login.getEmail();
        String password = login.getPassword();
        List<User> user = dao.select("SELECT * FROM BOSS.USERS WHERE email='" + email + "' AND password='" + password + "'");
        List<Szaki> szaki = dao.selectSzaki("select * from boss.szaki where (email='" + email + "' and password='" + password + "')");

        ModelAndView mv = new ModelAndView(getSuccessView());
        if (!(user.isEmpty())) {
            mv.addObject("login", user);
            mv.addObject("loggedUser", command);
        }
        if (!(szaki.isEmpty())) {
            mv.addObject("login", szaki);
            mv.addObject("loggedUser", command);
        }
        System.out.println(command);
        System.out.println(szaki);
        System.out.println(user);
        return mv;
    }

}
