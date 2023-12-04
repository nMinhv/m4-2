package com.smartTech.service;

import com.smartTech.dto.rp.CategoryDto;
import com.smartTech.model.entity.Category;

import java.util.List;

public interface CategoryService extends IGenericService<Category,Integer> {
    List<CategoryDto> getAllDto();
}
