/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.dao;

import com.szaki.dao.mapper.ProfessionRowMapper;
import com.szaki.dao.mapper.SzakiRowMapper;
import com.szaki.dao.mapper.UserRowMapper;
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
    private List<User> user;
    private List<Szaki> szaki;
    private int lastId;

    /**
     * A dataSource változó lesz az adatforrás helye.
     * Az adatforrást külön kell beállitani és itt csak meg kell adni azt.
     * @param dataSource 
     */
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * A metódus létrehoz egy sort a boss.users táblában.
     * @param firstName
     * @param lastName
     * @param email
     * @param password 
     */
    @Override
    public void createUser(String firstName, String lastName, String email, String password) {
        user = selectAllUser();
        lastId = user.size() + 1;
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        // TODO megkeresni a legutolso id-t
        insert.update("INSERT INTO boss.users (id, firstname, lastname, email, password) VALUES(" + lastId + ", '" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "')");
    }

    /**
     * A metódus létrehoz egy sort a boss.szaki táblában.
     * A szakiData tömbnek sorrendben kell tartalmazni a létrehozáshoz szükséges adatokat.
     * firstname, lastname, nameofcompany, email, phone, profession1, profession2, profession3,
     * country, county, city, street, number, password
     * @param szakiData 
     */
    @Override
    public void createSzaki(String[] szakiData) {
        szaki = selectAllSzaki();
        lastId = szaki.size() + 1;
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO boss.szaki (id, firstname, lastname, nameofcompany, email, phone, profession1, profession2, profession3, country, county, city, street, number, password) "
                + "VALUES(" + lastId + ", '" + szakiData[0] + "', '" + szakiData[1] + "', '" + szakiData[2] + "', '" + szakiData[3] + "', '" + szakiData[4] + "', '" + szakiData[5] + "', '" + szakiData[6] + "', '"
                + szakiData[7] + "', '" + szakiData[8] + "', '" + szakiData[9] + "', '" + szakiData[10] + "', '" + szakiData[11] + "', '" + szakiData[12] + "', '" + szakiData[13] + "')");
    }

    /**
     * A boss.users táblában keres.
     * A selectSql String-et lefutatja és vissza adja a kérésre kapot eredményt.
     * A selectSql-nek kell tartalmaznia az SQL parancsot.
     * @param selectSql
     * @return 
     */
    @Override
    public List<User> select(String selectSql) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(selectSql, new UserRowMapper());
    }

    /**
     * Vissza adja az összes sort a boss.useres táblából.
     * @return 
     */
    @Override
    public List<User> selectAllUser() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("select ID, FIRSTNAME, LASTNAME, EMAIL from boss.users", new UserRowMapper());
    }

    /**
     * Vissza adja az összes sort a boss.szaki táblából.
     * @return 
     */
    @Override
    public List<Szaki> selectAllSzaki() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("select id, firstname, lastname, nameofcompany ,email, phone, profession1, profession2, profession3, country, county, city, street, number from boss.szaki", new SzakiRowMapper());
    }

    /**
     * Lefutatja a deleteSql Stringet.
     * @param deleteSql 
     */
    @Override
    public void delete(String deleteSql) {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update(deleteSql);
    }

    /**
     * Mindent kitörölne.
     * Egynelőre nincs megírva.
     */
    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Vissza adja az összes szakmát a boss.profession táblából.
     * @return 
     */
    @Override
    public List<Profession> selectAllProfession() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("select id, name from boss.profession", new ProfessionRowMapper());
    }

}
