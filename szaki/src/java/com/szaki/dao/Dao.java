/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.dao;

import com.szaki.domain.User;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Dani
 */
public interface Dao {

    public void setDataSource(DataSource dataSource);

    public void create(String firstName, String lastName, String email, String password);

    List<User> select(String selectSql);

    List<User> selectAll();

    public void delete(String deleteSql);

    public void deleteAll();
}
