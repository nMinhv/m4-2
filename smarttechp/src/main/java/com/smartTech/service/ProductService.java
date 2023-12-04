package com.smartTech.service;

import com.smartTech.dto.rp.ProductDto;
import com.smartTech.model.entity.Product;

import java.util.List;

public interface ProductService extends IGenericService<Product,Integer>{
    List<ProductDto> productsDto();
    List<Integer> findAblePage();

    List<ProductDto> productPerPage(Integer page);
    ProductDto getProductDto(Integer id);
}
