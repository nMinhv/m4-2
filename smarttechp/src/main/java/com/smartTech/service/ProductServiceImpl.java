package com.smartTech.service;

import com.smartTech.dto.rp.ProductDto;
import com.smartTech.model.dao.ProductDao;
import com.smartTech.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryService categoryService;
    @Override
    public List<Product> getAll() {
        return null;
    }
    @Override
    public Product getOne(Integer id) {
        return productDao.getOne(id);
    }
    @Override
    public boolean updateAndSave(Product product) {
        return productDao.updateAndSave(product);
    }
    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<ProductDto> productsDto() {
        return productDao.getAllDto();
    }
    @Override
    public List<Integer> findAblePage(){
        List<Integer> ablePage = new ArrayList<>();
        int totalProduct = productDao.getAllDto().size();
        int totalPage = (int) Math.ceil((double) totalProduct / 12);
        for (int i = 1; i <= totalPage ; i++) {
            ablePage.add(i);
        }
        return ablePage;
    }

    @Override
    public List<ProductDto> productPerPage(Integer page) {
        return productDao.getProductPerPage(page);
    }

    @Override
    public ProductDto getProductDto(Integer id) {
        for (ProductDto p: productsDto()) {
            if(p.getProductId().equals(id)){
                return p;
            }
        }
        return null;
    }
}
