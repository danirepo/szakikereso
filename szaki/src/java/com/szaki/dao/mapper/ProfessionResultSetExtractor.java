/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.dao.mapper;

import com.szaki.domain.Profession;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Dani
 */
public class ProfessionResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        Profession profession = new Profession();
        profession.setId(rs.getInt("id"));
        profession.setName(rs.getString("name"));
        return profession;
    }

}
