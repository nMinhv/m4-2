package com.smartTech.model.dao;

import com.smartTech.dto.rp.ProductDto;
import com.smartTech.model.entity.Product;

import java.util.List;

public interface ProductDao extends IGenericDAO<Product,Integer> {
    List<ProductDto> getAllDto();

    List<ProductDto> getProductPerPage(Integer page);
}
