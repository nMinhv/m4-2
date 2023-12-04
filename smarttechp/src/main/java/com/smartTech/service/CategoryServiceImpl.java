package com.smartTech.service;


import com.smartTech.dto.rp.CategoryDto;
import com.smartTech.model.dao.CategoryDao;
import com.smartTech.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;
    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public Category getOne(Integer id) {
        return categoryDao.getOne(id);
    }

    @Override
    public boolean updateAndSave(Category category) {
        return categoryDao.updateAndSave(category);
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<CategoryDto> getAllDto() {
        return categoryDao.getAllDto();
    }
}
