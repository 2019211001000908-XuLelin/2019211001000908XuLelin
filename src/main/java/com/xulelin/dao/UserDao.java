package com.xulelin.dao;

import com.xulelin.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String Username, String Password) throws SQLException {

        String sql = "select * from usertable where Username=? and Password=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, Username);
        st.setString(2, Password);
        ResultSet rs = st.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("Username"));
            user.setPassword(rs.getString("Password"));
            user.setEmail(rs.getString("Email"));
            user.setGender(rs.getString("Gender"));
            user.setBirthDate(rs.getDate("BirthDate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String Username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String Password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String Email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String Gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthDate(Connection con, Date BirthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
