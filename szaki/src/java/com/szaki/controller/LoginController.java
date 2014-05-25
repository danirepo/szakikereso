/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.controller;

import com.szaki.dao.Dao;
import com.szaki.dao.DerbyDao;
import com.szaki.domain.Szaki;
import com.szaki.domain.User;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dani
 */
@Controller
public class LoginController {

    private DerbyDao dao = new DerbyDao();

    @RequestMapping(value = "/profile**", method = RequestMethod.GET)
    public ModelAndView profilePage() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/szakiDB;create=true");
        dataSource.setUsername("boss");
        dataSource.setPassword("omygod");

        dao.setDataSource(dataSource);

        List<User> listOfUser = dao.selectAllUser();
        List<Szaki> listOfSzaki = dao.selectAllSzaki();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listOfUser", listOfUser);
        modelAndView.addObject("listOfSzaki", listOfSzaki);
        modelAndView.setViewName("profile");
        return modelAndView;
    }


    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView modelAndView = new ModelAndView();

        if (error != null) {
            modelAndView.addObject("error", "Hibás email cím vagy jelszó!");
        }
        if (logout != null) {
            modelAndView.addObject("msg", "Sikeresen kijelentkezet");
        }

        modelAndView.setViewName("index");
        return modelAndView;
    }
}
