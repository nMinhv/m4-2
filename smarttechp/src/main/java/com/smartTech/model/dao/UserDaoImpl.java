package com.smartTech.model.dao;

import com.smartTech.dto.rp.UserLoginRpDto;
import com.smartTech.dto.rq.UserLoginRqDto;
import com.smartTech.model.entity.User;
import com.smartTech.util.ConnectionDataBase;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getOne(Integer id) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "";
        try {
            CallableStatement cs = connection.prepareCall(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return null;
    }

    @Override
    public boolean updateAndSave(User user) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "";
            sql = "CALL ADD_USER_PROC(?,?,?,?)";
        if (user.getUserId() != null) {
            sql = "CALL UPDATE_USER_PROC(?,?,?,?,?,?)";
        }
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setString(1, user.getUserName());
            cs.setString(2, user.getEmail());
            cs.setString(3, user.getPassword());
            cs.setString(4, user.getPhone());
            if(user.getUserId() != null){
                cs.setInt(5,user.getUserId());
                cs.setInt(6,user.getStatus());
            }
            int c = cs.executeUpdate();
            if (c > 0) {
                return true;
            }
        } catch (SQLException e ) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public UserLoginRpDto login(UserLoginRqDto loginRq) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL LOGIN_PROC(?)";
        try {
            UserLoginRpDto loginRp = new UserLoginRpDto();
            CallableStatement cs = connection.prepareCall(sql);
            cs.setString(1, loginRq.getEmail());
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                String hpw = rs.getString("password");
                if (BCrypt.checkpw(loginRq.getPassword(), hpw)) {
                    loginRp.setUserId(rs.getInt("userId"));
                    loginRp.setUserName(rs.getString("userName"));
                    loginRp.setEmail(rs.getString("email"));
                    loginRp.setPhone(rs.getString("phone"));
                    loginRp.setRole(rs.getByte("role"));
                    loginRp.setStatus(rs.getByte("status"));
                }
            }
            if(loginRp.getUserId() != null){
            return loginRp;
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
    }

    @Override
    public List<String> uniqueList(String col) {
        List<String> list = new ArrayList<>();
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "SELECT " + col +" FROM smart_tech_user";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(rs.getString(col));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return list;
    }


}
