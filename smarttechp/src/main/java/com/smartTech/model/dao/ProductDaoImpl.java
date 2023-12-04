package com.smartTech.model.dao;

import com.smartTech.dto.rp.ProductDto;
import com.smartTech.model.entity.Product;
import com.smartTech.util.ConnectionDataBase;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository

public class ProductDaoImpl implements ProductDao{
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getOne(Integer id) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL GET_PRODUCT_BY_ID(?)";
        Product product = new Product();
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1,id);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setDes(rs.getString("des"));
                product.setStock(rs.getInt("stock"));
                product.setStatus(rs.getByte("status"));
                product.setPreviewImg(rs.getString("previewImg"));
            }
            if (product.getProductId() != null){
                return product;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return null;
    }

    @Override
    public boolean updateAndSave(Product product) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "";
            sql = "CALL ADD_PRODUCT_PROC(?,?,?,?,?,?,?)";
            if(product.getProductId() != null){
                sql = "CALL UPDATE_PRODUCT_PROC(?,?,?,?,?,?,?,?)";
                System.out.println(product.getProductId());
            }
        try {
            CallableStatement cs = connection.prepareCall(sql);
                cs.setString(1,product.getProductName());
                cs.setDouble(2,product.getProductPrice());
                cs.setString(3,product.getDes());
                cs.setInt(4,product.getStock());
                cs.setByte(5,product.getStatus());
                cs.setInt(6,product.getCategory_id());
                cs.setString(7,product.getPreviewImg());
                if(product.getProductId() != null){
                    cs.setInt(8, product.getProductId());
                }
                int c = cs.executeUpdate();
                return c > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDataBase.closeConnection(connection);
        }

    }

    @Override
    public boolean delete(Integer id) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "";
        try {
            CallableStatement cs = connection.prepareCall(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return false;
    }

    @Override
    public List<ProductDto> getAllDto() {
        Connection connection = ConnectionDataBase.openConnection();
        List<ProductDto> productDtoList = new ArrayList<>();
        String sql = "CALL GET_PRODUCTS_DTO()";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                ProductDto productDto = new ProductDto();
                productDto.setProductId(rs.getInt("productId"));
                productDto.setProductName(rs.getString("productName"));
                productDto.setProductPrice(rs.getDouble("productPrice"));
                productDto.setDes(rs.getString("des"));
                productDto.setStock(rs.getInt("stock"));
                productDto.setStatus(rs.getByte("status"));
                productDto.setPreviewImg(rs.getString("previewImg"));
                productDto.setCategory_name(rs.getString("categoryName"));
                productDtoList.add(productDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> getProductPerPage(Integer page) {
        Connection connection = ConnectionDataBase.openConnection();
        List<ProductDto> productDtoList = new ArrayList<>();
        String sql = "CALL GET_PRODUCT_PAGE_PROC(?)";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1,page);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                ProductDto productDto = new ProductDto();
                productDto.setProductId(rs.getInt("productId"));
                productDto.setProductName(rs.getString("productName"));
                productDto.setProductPrice(rs.getDouble("productPrice"));
                productDto.setDes(rs.getString("des"));
                productDto.setStock(rs.getInt("stock"));
                productDto.setStatus(rs.getByte("status"));
                productDto.setPreviewImg(rs.getString("previewImg"));
                productDto.setCategory_name(rs.getString("categoryName"));
                productDtoList.add(productDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return productDtoList;
    }

}
