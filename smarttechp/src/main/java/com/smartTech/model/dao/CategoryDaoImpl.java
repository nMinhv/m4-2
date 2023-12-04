package com.smartTech.model.dao;
import com.smartTech.dto.rp.CategoryDto;
import com.smartTech.model.entity.Category;
import com.smartTech.util.ConnectionDataBase;
import org.springframework.stereotype.Repository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL GET_ALL_CATEGORY_PROC()";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getInt("categoryId"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setStatus(rs.getByte("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return categories;
    }

    @Override
    public Category getOne(Integer integer) {
        return null;
    }

    @Override
    public boolean updateAndSave(Category category) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql= "";
            sql = "CALL ADD_CATEGORY_PROC(?,?,?)";
        if(category.getCategoryId() != null){
            sql = "CALL UPDATE_CATEGORY_PROC(?,?,?,?)";
        }
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setString(1, category.getCategoryName());
            cs.setByte(3, category.getStatus());
            if (category.getParentId() != null) {
                cs.setInt(2, category.getParentId());
            } else {
                cs.setInt(2, 0);
            }
            if(category.getCategoryId() != null){
                cs.setInt(4,category.getCategoryId());
            }
            int check = cs.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<CategoryDto> getAllDto() {
        List<CategoryDto> categories = new ArrayList<>();
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL GET_ALL_CATEGORY_WITH_P()";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                CategoryDto category = new CategoryDto();
                category.setCategoryId(rs.getInt("categoryId"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setParentName(rs.getString("parentName"));
                category.setParentId(rs.getInt("parentId"));
                category.setStatus(rs.getByte("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return categories;
    }
}
