/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.dao;

import com.szaki.dao.mapper.LoginRowMapper;
import com.szaki.dao.mapper.ProfessionRowMapper;
import com.szaki.dao.mapper.SzakiRowMapper;
import com.szaki.dao.mapper.UserRowMapper;
import com.szaki.domain.Login;
import com.szaki.domain.Profession;
import com.szaki.domain.Szaki;
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
    private List<User> listOfUser;
    private List<Szaki> listOfSzaki;
    private List<Login> listOfLogin;
    private int lastId;

    public DerbyDao() {
    }

    /**
     * A dataSource változó lesz az adatforrás helye. Az adatforrást külön kell
     * beállitani és itt csak meg kell adni azt.
     *
     * @param dataSource
     */
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        syncronizing();
    }

    /**
     * A metódus létrehoz egy sort a boss.users táblában.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     */
    @Override
    public void createUser(String firstName, String lastName, String email, String password) {
        listOfUser = selectAllUser();
        lastId = listOfUser.size() + 1;
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        // TODO megkeresni a legutolso id-t
        insert.update("INSERT INTO boss.users (id, firstname, lastname, email, password) VALUES(" + lastId + ", '" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "')");
        syncronizing();
    }

    /**
     * A metódus létrehoz egy sort a boss.szaki táblában. A szakiData tömbnek
     * sorrendben kell tartalmazni a létrehozáshoz szükséges adatokat.
     * firstname, lastname, nameofcompany, email, phone, profession1,
     * profession2, profession3, country, county, city, street, number, password
     *
     * @param szakiData
     */
    @Override
    public void createSzaki(String[] szakiData) {
        listOfSzaki = selectAllSzaki();
        lastId = listOfSzaki.size() + 1;
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO boss.szaki (id, firstname, lastname, nameofcompany, email, profession1, profession2, profession3, country, county, city, street, password, phone, number) "
                + "VALUES(" + lastId + ", '" + szakiData[0] + "', '" + szakiData[1] + "', '" + szakiData[2] + "', '" + szakiData[3] + "', '" + szakiData[4] + "', '" + szakiData[5] + "', '" + szakiData[6] + "', '"
                + szakiData[7] + "', '" + szakiData[8] + "', '" + szakiData[9] + "', '" + szakiData[10] + "', '" + szakiData[11] + "', '" + szakiData[12] + "', '" + szakiData[13] + "')");
        syncronizing();
    }

    /**
     * A boss.users táblában keres. A selectSql String-et lefutatja és vissza
     * adja a kérésre kapot eredményt. A selectSql-nek kell tartalmaznia az SQL
     * parancsot.
     *
     * @param selectSql
     * @return
     */
    @Override
    public List<User> select(String selectSql) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(selectSql, new UserRowMapper());
    }

    @Override
    public List<Szaki> selectSzaki(String selectSql) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(selectSql, new SzakiRowMapper());
    }

    /**
     * Vissza adja az összes sort a boss.useres táblából.
     *
     * @return
     */
    @Override
    public List<User> selectAllUser() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("select * from boss.users", new UserRowMapper());
    }

    /**
     * Vissza adja az összes sort a boss.szaki táblából.
     *
     * @return
     */
    @Override
    public List<Szaki> selectAllSzaki() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("select * from boss.szaki", new SzakiRowMapper());
    }

    /**
     * Lefutatja a deleteSql Stringet.
     *
     * @param deleteSql
     */
    @Override
    public void delete(String deleteSql) {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update(deleteSql);
        syncronizing();
    }

    /**
     * Mindent kitörölne. Egynelőre nincs megírva.
     */
    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Vissza adja az összes szakmát a boss.profession táblából.
     *
     * @return
     */
    @Override
    public List<Profession> selectAllProfession() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("select * from boss.profession", new ProfessionRowMapper());
    }

    @Override
    public List<Login> selectAllLogin() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("select * from boss.login", new LoginRowMapper());
    }

    @Override
    public List<Login> selectLoginUser() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createLoginUser(int userId, String email, String password, int access) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        listOfLogin = selectAllLogin();
        lastId = listOfLogin.size() + 1;
        insert.update("insert into boss.login (id, userid, email, password, access) values(" + lastId + ", " + userId + ", '" + email + "', '" + password + "', " + access + ")");
    }

    private void syncronizing() {
        listOfSzaki = selectAllSzaki();
        listOfUser = selectAllUser();
        listOfLogin = selectAllLogin();
        boolean hasFound = false;

        for (User userItem : listOfUser) {
            for (Login loginItem : listOfLogin) {
                if (loginItem.getAccess() == 1) {
                    if (userItem.getId() == loginItem.getUserId()) {
                        hasFound = true;
                    }
                }
            }
            if (hasFound == false) {
                createLoginUser(userItem.getId(), userItem.getEmail(), userItem.getPassword(), 1);
            }
            hasFound = false;
        }

        for (Szaki szakiItem : listOfSzaki) {
            for (Login loginItem : listOfLogin) {
                if (loginItem.getAccess() == 2) {
                    if (szakiItem.getId() == loginItem.getUserId()) {
                        hasFound = true;
                    }
                }
            }
            if (hasFound == false) {
                createLoginUser(szakiItem.getId(), szakiItem.getEmail(), szakiItem.getPassword(), 2);
            }
            hasFound = false;
        }

        for (Login loginItem : listOfLogin) {
            for (User userItem : listOfUser) {
                if (loginItem.getAccess() == 1) {
                    if (loginItem.getUserId() == userItem.getId()) {
                        hasFound = true;
                    }
                }
            }
            if (hasFound == false) {
                for (Szaki szakiItem : listOfSzaki) {
                    if (loginItem.getAccess() == 2) {
                        if (loginItem.getUserId() == szakiItem.getId()) {
                            hasFound = true;
                        }
                    }
                }
            }
            if (hasFound == false) {
                delete("delete from boss.login where id=" + loginItem.getId());
            }
            hasFound = false;
        }
    }
}
