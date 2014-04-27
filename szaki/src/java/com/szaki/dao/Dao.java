/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.dao;

import com.szaki.domain.Login;
import com.szaki.domain.Profession;
import com.szaki.domain.Szaki;
import com.szaki.domain.User;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Dani
 */
public interface Dao {

    public void setDataSource(DataSource dataSource);

    public void createUser(String firstName, String lastName, String email, String password);

    public void createSzaki(String[] szakiData);

    public List<User> select(String selectSql);

    public List<Szaki> selectSzaki(String selectSql);

    public List<User> selectAllUser();

    public List<Szaki> selectAllSzaki();

    public List<Profession> selectAllProfession();

    public List<Login> selectAllLogin();

    public List<Login> selectLoginUser();

    public void createLoginUser(int userId, String email, String password, int access);

    public void delete(String deleteSql);

    public void deleteAll();
}
