/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.dao.mapper;

import com.szaki.domain.Rating;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Dani
 */
public class RatingResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        Rating rating = new Rating();
        rating.setId(rs.getInt("id"));
        rating.setMark(rs.getInt("mark"));
        rating.setDescription(rs.getString("description"));
        rating.setDate(rs.getString("date"));
        rating.setSender(rs.getString("sender"));
        rating.setSzaki(rs.getString("szaki"));
        return rating;
    }

}
