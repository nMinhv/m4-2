package com.riode.model.dao;

import com.riode.model.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CategoryDaoImpl implements CategoryDao{
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
