package com.xulelin.dao;

import com.xulelin.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IUserDao {
    public boolean saveUser(Connection con, User user) throws SQLException;

    public int deleteUser(Connection con, User user) throws SQLException;

    public int updateUser(Connection con, User user) throws SQLException;

    public User findById(Connection con, Integer id) throws SQLException;

    public User findByUsernamePassword(Connection con, String Username, String Password) throws SQLException;

    public List<User> findByUsername(Connection con, String Username) throws SQLException;

    public List<User> findByPassword(Connection con, String Password) throws SQLException;

    public List<User> findByEmail(Connection con, String Email) throws SQLException;

    public List<User> findByGender(Connection con, String Gender) throws SQLException;

    public List<User> findByBirthDate(Connection con, Date BirthDate) throws SQLException;

    public List<User> findAllUser(Connection con) throws SQLException;


}
