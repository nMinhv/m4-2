package com.example.model.dao;

import com.example.model.entity.Category;
import com.example.util.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        String sql = "CALL GET_ALL_CATEGORY()";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getInt("categoryId"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setStatus(rs.getBoolean("status"));
                list.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    @Override
    public Boolean saveOrUpdate(Category category) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        try {
            String sql;
            if (category.getCategoryId() != null) {
                sql = "CALL UPDATE_CATEGORY_PROC(?,?,?)";
            } else {
                sql = "CALL ADD_CATEGORY(?,?)";
            }
            CallableStatement cs = connection.prepareCall(sql);

            cs.setString(1, category.getCategoryName());
            cs.setBoolean(2, category.getStatus());
            if (category.getCategoryId() != null) {
                cs.setInt(3, category.getCategoryId());
            }
            int rs = cs.executeUpdate();
            if (rs > 0) {
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
    public Boolean delete(Integer id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "CALL DELETE_CATEGORY_BY_ID(?)";
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall(sql);
            cs.setInt(1, id);
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
    public Category findById(Integer id) {
        Connection connection = ConnectionDB.openConnection();
        Category category = new Category();
        try {
            String sql = "CALL GET_CATEGORY_BY_ID(?)";
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                category.setCategoryId(rs.getInt("categoryId"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setStatus(rs.getBoolean("status"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        System.out.println(category.getCategoryId());
        return category;
    }
}
