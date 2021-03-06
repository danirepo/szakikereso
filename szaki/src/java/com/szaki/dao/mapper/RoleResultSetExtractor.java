/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.dao.mapper;

import com.szaki.domain.LoginRoles;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Dani
 */
public class RoleResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        LoginRoles loginRoles = new LoginRoles();
        loginRoles.setRoleId(rs.getInt("user_role_id"));
        loginRoles.setEmail(rs.getString("email"));
        loginRoles.setRole(rs.getString("role"));
        return loginRoles;
    }

}
