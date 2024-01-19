package com.example.hr_system.service.Impl;

import com.example.hr_system.models.Category;
import com.example.hr_system.repository.CategoryRepository;
import com.example.hr_system.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setId(categoryRequest.getId());
        category.setName(categoryRequest.getName());

        categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(Long id, CategoryRequest categoryRequest) {
        Category category1 = categoryRepository.findById(id).get();

        category1.setName(categoryRequest.getName());
        return categoryRepository.save(category1);
    }
}

