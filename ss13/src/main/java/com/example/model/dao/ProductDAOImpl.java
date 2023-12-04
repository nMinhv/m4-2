package com.example.model.dao;

import com.example.model.entity.Category;
import com.example.model.entity.Product;
import com.example.util.ConnectionDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Service
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Product> findAll() {
        Connection connection = ConnectionDB.openConnection();
        List<Product> list = new ArrayList<>();
        String sql = "CALL GET_ALL_PRODUCT()";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                Category category = categoryDAO.findById(rs.getInt("category_id"));
                product.setCategory(category);
                list.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return list;
    }

    @Override
    public Boolean saveOrUpdate(Product product) {
        Connection connection = ConnectionDB.openConnection();
        String sql;
        try {
            if (product.getProductId() != null) {
                sql = "CALL UPDATE_PRODUCT_BY_ID(?,?,?,?,?)";
            } else {
                sql = "CALL ADD_PRODUCT_PROC(?,?,?,?)";
            }
            CallableStatement cs = connection.prepareCall(sql);
            cs.setString(1, product.getProductName());
            cs.setDouble(2, product.getPrice());
            cs.setString(3, product.getImage());
            cs.setInt(4, product.getCategory().getCategoryId());
            if (product.getProductId() != null) {
                cs.setInt(5, product.getProductId());
            }
            int check = cs.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Boolean delete(Integer integer) {
        return null;
    }

    @Override
    public Product findById(Integer id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "CALL GET_PRODUCT_BY_ID(?)";
        Product product = new Product();
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Category category = categoryDAO.findById(rs.getInt("category_id"));
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setImage(rs.getString("image"));
                product.setCategory(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }
}
