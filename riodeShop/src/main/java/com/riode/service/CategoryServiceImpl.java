package com.riode.service;


import com.riode.model.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public Category getOne(Integer integer) {
        return null;
    }

    @Override
    public boolean updateAndSave(Category category) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
