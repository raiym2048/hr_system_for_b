package com.example.hr_system.controller;

import com.example.hr_system.models.Category;
import com.example.hr_system.service.Impl.CategoryRequest;
import com.example.hr_system.service.Impl.CategoryResponse;
import com.example.hr_system.service.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TestCategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("/get/categories")
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryService.getAllCategory();
        return mapToCategoryResponses(categories);
    }

    @GetMapping("/get/category/{id}")
    public CategoryResponse getCategoryById(@PathVariable("id") Long id) {
        Optional<Category> optionalCategory = categoryService.getCategoryById(id);
        return optionalCategory.map(this::mapToCategoryResponse).orElse(null);
    }

    @GetMapping("delete/category/{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategoryById(id);
    }

    @PostMapping("/update/category/{id}")
    public CategoryResponse updateCategory(@PathVariable("id") Long id, @RequestBody CategoryRequest categoryRequest) {
        Category updatedCategory = categoryService.updateCategory(id, categoryRequest);
        return mapToCategoryResponse(updatedCategory);
    }

    @PostMapping("/create/category")
    public void createCategory(@RequestBody CategoryRequest categoryRequest){
        categoryService.createCategory(categoryRequest);
    }

    private CategoryResponse mapToCategoryResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        return categoryResponse;
    }

    private List<CategoryResponse> mapToCategoryResponses(List<Category> categories) {
        return categories.stream()
                .map(this::mapToCategoryResponse)
                .collect(Collectors.toList());
    }
}
