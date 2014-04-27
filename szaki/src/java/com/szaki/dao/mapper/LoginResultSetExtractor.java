/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.dao.mapper;

import com.szaki.domain.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Dani
 */
public class LoginResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        Login login = new Login();
        login.setId(rs.getInt("id"));
        login.setUserId(rs.getInt("userid"));
        login.setEmail(rs.getString("email"));
        login.setPassword(rs.getString("password"));
        login.setAccess(rs.getInt("access"));
        return login;
    }

}
