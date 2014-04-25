/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.dao.mapper;

import com.szaki.domain.Szaki;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Dani
 */
public class SzakiResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        Szaki szaki = new Szaki();
        szaki.setId(rs.getInt("id"));
        szaki.setFirstName(rs.getString("firstname"));
        szaki.setLastName(rs.getString("lastname"));
        szaki.setNameOfCompany(rs.getString("nameofcompany"));
        szaki.setEmail(rs.getString("email"));
        szaki.setPhone(rs.getString("phone"));
        szaki.setProfession1(rs.getString("profession1"));
        szaki.setProfession2(rs.getString("profession2"));
        szaki.setProfession3(rs.getString("profession3"));
        szaki.setCountry(rs.getString("country"));
        szaki.setCounty(rs.getString("county"));
        szaki.setCity(rs.getString("city"));
        szaki.setStreet(rs.getString("street"));
        szaki.setNumber(rs.getString("number"));
        return szaki;
    }

}
