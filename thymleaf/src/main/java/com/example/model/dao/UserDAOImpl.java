package com.example.model.dao;

import com.example.model.entity.User;
import com.example.util.ConnectionDB;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import javax.servlet.http.Cookie;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Override
    public Boolean updateAndSave(User user) {
        Connection connection = ConnectionDB.openConnection();
        String salt = BCrypt.gensalt();
        String hashedPass = BCrypt.hashpw(user.getPassword(),salt);
        String sql = "CALL CREATE_ACCOUNT(?,?,?,?,?)";
        if (user.getUserId() != null) {
            sql = "";
        }
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setString(1, user.getUserName());
            cs.setString(2, user.getEmail());
            cs.setString(3, hashedPass);
            cs.setString(4, user.getPhone());
            cs.setBoolean(5, false);
            int check = cs.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public Boolean delete(Integer integer) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User login(User user) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "CALL PROC_FIND_USER(?)";
        User getUser = new User();
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setString(1, user.getEmail());
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                getUser.setUserName(rs.getString("userName"));
                getUser.setUserId(rs.getInt("userId"));
                getUser.setEmail(rs.getString("email"));
                getUser.setPassword(rs.getString("password"));
                getUser.setPhone(rs.getString("phone"));
                getUser.setRole(rs.getBoolean("role"));
            }

            if (BCrypt.checkpw(user.getPassword(),getUser.getPassword())) {
                return getUser;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return null;
    }
}
