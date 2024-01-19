package com.example.hr_system.service;

import com.example.hr_system.models.Category;
import com.example.hr_system.service.Impl.CategoryRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategory();

    Optional<Category> getCategoryById(Long id);

    void createCategory(CategoryRequest categoryRequest);

    void deleteCategoryById(Long id);

    Category updateCategory(Long id, CategoryRequest categoryRequest);
}
