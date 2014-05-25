/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.controller;

import com.szaki.dao.DerbyDao;
import com.szaki.domain.Szaki;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Dani
 */
public class AdminSzakiController extends SimpleFormController {

    private DerbyDao dao = new DerbyDao();

    public AdminSzakiController() {
        setCommandClass(Szaki.class);
        setCommandName("szakiModifyCommand");
        setSuccessView("szakiMofySuccessView");
        setFormView("szakiModify");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/szakiDB;create=true");
        dataSource.setUsername("boss");
        dataSource.setPassword("omygod");

        dao.setDataSource(dataSource);
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Object command, BindException errors) throws Exception {
        Szaki szaki = (Szaki) command;
        String deleteSql = "DELETE FROM users WHERE email='" + szaki.getEmail() + "'";
        dao.delete(deleteSql);
        ModelAndView mv = new ModelAndView(getSuccessView());
        //Do something...
        return mv;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map referenceDate = new HashMap();
        List<Szaki> listOfSzaki = dao.selectAllSzaki();
        referenceDate.put("listOfSzaki", listOfSzaki);
        return referenceDate;
    }

}
