package com.example.model.service;
import com.example.model.dao.CategoryDAO;
import com.example.model.dao.CategoryDAOImpl;
import com.example.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Boolean saveOrUpdate(Category category) {
      return  categoryDAO.saveOrUpdate(category);
    }
    @Override
    public Boolean delete(Integer id) {
        return categoryDAO.delete(id);
    }

    @Override
    public Category findById(Integer id) {
        return categoryDAO.findById(id);
    }
}
