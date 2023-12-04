package com.example.model.service;

import com.example.model.dao.ProductDAO;
import com.example.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Boolean saveOrUpdate(Product product) {
        return productDAO.saveOrUpdate(product);
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public Product findById(Integer id) {
        return productDAO.findById(id);
    }
}
