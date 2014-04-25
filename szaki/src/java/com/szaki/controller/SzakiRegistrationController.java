/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.controller;

import com.szaki.dao.DerbyDao;
import com.szaki.domain.Profession;
import com.szaki.domain.Szaki;
import java.util.ArrayList;
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
public class SzakiRegistrationController extends SimpleFormController {

    private String[] szakiData;
    private List<Profession> professions;
    DerbyDao dao = new DerbyDao();
    ModelAndView professionMv;

    public SzakiRegistrationController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/szakiDB;create=true");
        dataSource.setUsername("boss");
        dataSource.setPassword("omygod");

        //a dao adatforrásának megadása
        dao.setDataSource(dataSource);

        professions = dao.selectAllProfession();
        for (Profession prof : professions) {
            System.out.println("\n\n");
            System.out.println(prof.getId() + ", " + prof.getName());
        }
        //professionMv = new ModelAndView("szakiRegistrationView", "profession", professions);
        
        setCommandClass(Szaki.class);
        setCommandName("szakiRegistration");
        //setSuccessView("szakiRegistrationSuccessView");
        setFormView("szakiRegistrationView");

    }

//    @Override
//    protected void doSubmitAction(Object command) throws Exception {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Object command, BindException errors) throws Exception {

        // Dao implementálás
        //Adatbázis kapcsolat beállitása ez az adatforrás
        Szaki szaki = (Szaki) command;

        //szakiData feltöltése a szakiRegistrationView-ban megadott adatokkal
        szakiData[0] = szaki.getFirstName();
        szakiData[1] = szaki.getLastName();
        szakiData[2] = szaki.getNameOfCompany();
        szakiData[3] = szaki.getEmail();
        szakiData[4] = szaki.getPhone();
        szakiData[5] = szaki.getProfession1();
        szakiData[6] = szaki.getProfession2();
        szakiData[7] = szaki.getProfession3();
        szakiData[8] = szaki.getCountry();
        szakiData[9] = szaki.getCounty();
        szakiData[10] = szaki.getCity();
        szakiData[11] = szaki.getStreet();
        szakiData[12] = szaki.getNumber();
        szakiData[13] = szaki.getPassword();

        //dao.createSzaki létrehozza az új adatbázis sort a szakiData adataival
        //dao.createSzaki(szakiData);
        //a ModelAndView lekéri a sikeres nézetet ami a szakiRegistrationSuccessView
        //ModelAndView mv = new ModelAndView(getSuccessView());
        //Do something...
        //return mv;
        return new ModelAndView("szkiRegistrationSuccessView", "szaki", szaki);
    }

    protected Map professionData(HttpServletRequest request) throws Exception {
        Map professionRef = new HashMap();
        List<String> frameworkList = new ArrayList<String>();
        frameworkList.add("egyes");
        frameworkList.add("ketets");
        frameworkList.add("hármas");
        //profession lista feltöltése a boss.profession táblából
//        professions.add((Profession) dao.selectAllProfession());
//        professionRef.put("professionData", professions);
        professionRef.put("frameworkList", frameworkList);
        return professionRef;
    }

}
