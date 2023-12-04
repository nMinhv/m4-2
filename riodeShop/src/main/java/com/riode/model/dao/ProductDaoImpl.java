package com.riode.model.dao;

import com.riode.model.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class ProductDaoImpl implements ProductDao{
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getOne(Integer integer) {
        return null;
    }

    @Override
    public boolean updateAndSave(Product product) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
