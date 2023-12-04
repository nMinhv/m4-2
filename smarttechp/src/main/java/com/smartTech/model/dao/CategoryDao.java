package com.smartTech.model.dao;

import com.smartTech.dto.rp.CategoryDto;
import com.smartTech.model.entity.Category;

import java.util.List;

public interface CategoryDao extends IGenericDAO<Category,Integer> {
    List<CategoryDto> getAllDto();
}
