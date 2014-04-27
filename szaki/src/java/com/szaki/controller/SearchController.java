/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.controller;

import com.szaki.dao.DerbyDao;
import com.szaki.domain.Profession;
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
public class SearchController extends SimpleFormController {

    private DerbyDao dao = new DerbyDao();
    private List<Profession> listOfProfessions;
    private StringBuffer sql;
    private String finalSql;
    private List<Szaki> foundList;

    public SearchController() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/szakiDB;create=true");
        dataSource.setUsername("boss");
        dataSource.setPassword("omygod");

        //a dao adatforrásának megadása
        dao.setDataSource(dataSource);

        //a szakmák lista feltöltése
        listOfProfessions = dao.selectAllProfession();

        //Initialize controller properties here or 
        //in the Web Application Context
        setCommandClass(Szaki.class);
        setCommandName("searching");
        setSuccessView("searchSuccessView");
        setFormView("searchView");
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
        Szaki szaki = (Szaki) command;
        String country = szaki.getCountry();
        String county = szaki.getCounty();
        String profession = szaki.getProfession();
        sql = new StringBuffer("select * from boss.szaki where ");

        sql.append("country='" + country + "' AND county='" + county + "'" + " AND (profession1='" + profession + "' OR profession2='" + profession + "' OR profession3='" + profession + "')");

        /*if (!(szaki.getProfession().isEmpty())) {
         sql.append(" OR profession1='" + szaki.getProfession() + "' OR profession2='" + szaki.getProfession() + "' OR profession3='" + szaki.getProfession() + "'");
         }*/
        System.out.println(szaki.getCountry());
        System.out.println(szaki.getProfession());

        finalSql = sql.toString();
        System.out.println(finalSql);

        foundList = dao.selectSzaki(finalSql);

        if (foundList.isEmpty()) {
            String noFound = "Nincs találat";
            return new ModelAndView("searchSuccessView", "notFound", noFound);
        } else {
            professionModify();
            return new ModelAndView("searchSuccessView", "foundList", foundList);
        }
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map refenceData = new HashMap();
        refenceData.put("listOfProfessions", listOfProfessions);
        return refenceData;
    }

    private void professionModify() {
        String tempProfession1, tempProfession2, tempProfession3;
        String tempId;
        for (Szaki listItem : foundList) {
            tempProfession1 = listItem.getProfession();
            tempProfession2 = listItem.getProfession2();
            tempProfession3 = listItem.getProfession3();
            for (Profession profession : listOfProfessions) {
                tempId = String.valueOf(profession.getId());
                if (tempProfession1.equals(tempId)) {
                    listItem.setProfession(profession.getName());
                }
                if (tempProfession2.equals(tempId)) {
                    listItem.setProfession2(profession.getName());
                }
                if (tempProfession3.equals(tempId)) {
                    listItem.setProfession3(profession.getName());
                }
            }
        }
    }

}
