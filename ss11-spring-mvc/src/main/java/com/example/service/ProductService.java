package com.example.service;

import com.example.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IGenericService<Product, Integer> {
    private final List<Product> list = new ArrayList<>();

    public ProductService() {
        list.add(new Product(1, "Product1", 10, "a", "none", 1));
        list.add(new Product(2, "Product2", 15, "b", "none", 2));
        list.add(new Product(3, "Product3", 20, "c", "none", 3));
    }


    @Override
    public List<Product> getAll() {
        return list;
    }

    @Override
    public boolean save(Product product) {
        Product product1 = findByID(product.getProductId());
        if(product1 == null){
        list.add(product);

        }else {
            product1.setpName(product.getpName());
            product1.setPrice(product.getPrice());
        }
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        Product product = findByID(id);
        if (product != null) {
            list.remove(product);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Product findByID(Integer id) {
        for (Product product : list) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean update(Product product) {
        if (product == null) {
            return false;
        }
        Product product1 = findByID(product.getCategoryId());
        product1 = product;
        return true;
    }
}
