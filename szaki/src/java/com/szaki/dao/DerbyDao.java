/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.dao;

import com.szaki.dao.mapper.UserRowMapper;
import com.szaki.domain.User;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Dani
 */
public class DerbyDao implements Dao {

    private DataSource dataSource;
    private List<User> user;
    private int lastId;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(String firstName, String lastName, String email, String password) {
        user = selectAll();
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        // TODO megkeresni a legutolso id-t
        lastId = user.size() + 1;
        insert.update("INSERT INTO boss.users (id, firstname, lastname, email, password) VALUES(" + lastId + ", '" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "')");
    }

    @Override
    public List<User> select(String selectSql) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(selectSql, new UserRowMapper());
    }

    @Override
    public List<User> selectAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("select ID, FIRSTNAME, LASTNAME, EMAIL from boss.users", new UserRowMapper());
    }

    @Override
    public void delete(String deleteSql) {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update(deleteSql);
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
