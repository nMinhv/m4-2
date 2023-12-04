package com.riode.service;

import com.riode.model.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
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
