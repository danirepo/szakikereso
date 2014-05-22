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
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Dani
 */
@SessionAttributes("loggedUser")
public class SzakiRegistrationController extends SimpleFormController {

    private String[] szakiData = new String[14];
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

        setCommandClass(Szaki.class);
        setCommandName("szakiRegistration");
        setSuccessView("szakiRegistrationSuccessView");
        setFormView("szakiRegistrationView");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        Szaki szaki = new Szaki();
        szaki.setProfession(new String("Ács"));
        return szaki;
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

        String selectedCheckbox = szaki.getProfession();
        String[] temp = new String[3];
        temp = selectedCheckbox.split(",");
        String[] selectedProfessions = new String[3];
        for (int i = 0; i < temp.length; i++) {
            selectedProfessions[i] = temp[i];
        }

        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        //szakiData feltöltése a szakiRegistrationView-ban megadott adatokkal
        szakiData[0] = szaki.getFirstName();
        szakiData[1] = szaki.getLastName();
        szakiData[2] = szaki.getNameOfCompany();
        szakiData[3] = szaki.getEmail();
        szakiData[4] = selectedProfessions[0];
        szakiData[5] = selectedProfessions[1];
        szakiData[6] = selectedProfessions[2];
        szakiData[7] = szaki.getCountry();
        szakiData[8] = szaki.getCounty();
        szakiData[9] = szaki.getCity();
        szakiData[10] = szaki.getStreet();
        szakiData[11] = md5.encodePassword(szaki.getPassword(), null);
        szakiData[12] = szaki.getPhone();
        szakiData[13] = szaki.getNumber();

        //dao.createSzaki létrehozza az új adatbázis sort a szakiData adataival
        dao.createSzaki(szakiData);

        //a ModelAndView lekéri a sikeres nézetet ami a szakiRegistrationSuccessView
        //ModelAndView mv = new ModelAndView(getSuccessView());
        //Do something...
        //return mv;
        for (int i = 0; i < 13; i++) {
//            System.out.println(szakiData[i]);
        }
        return new ModelAndView("szakiRegistrationSuccessView", "szaki", szaki);
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map referenceData = new HashMap();
        List<Profession> professionsList;
        professionsList = dao.selectAllProfession();
        referenceData.put("professionsList", professionsList);
        return referenceData;
    }

}
