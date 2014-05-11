/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.controller;

import com.szaki.dao.DerbyDao;
import com.szaki.domain.Rating;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class RatingController extends SimpleFormController {

    public RatingController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Rating.class);
        setCommandName("ratingCommand");
        setSuccessView("ratingSuccessView");
        setFormView("ratingView");
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

        Rating rating = (Rating) command;

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        System.out.println(dateFormat.format(date));

        int mark = rating.getMark();
        String description = rating.getDescription();
        String sender = rating.getSender();
        String szaki = rating.getSzaki();

        dao.createRating(mark, description, dateFormat.format(date), sender, szaki);
        ModelAndView mv = new ModelAndView(getSuccessView());
        return mv;
    }

}
