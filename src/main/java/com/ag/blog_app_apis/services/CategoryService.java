package com.ag.blog_app_apis.services;

import com.ag.blog_app_apis.payloads.CategoryDTO;

import java.util.List;

public interface CategoryService {
    //create
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    //update
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);
    //getAllCategory
    List<CategoryDTO> getAllCategories();
    //getCategoryById
    CategoryDTO getCategoryById(Integer categoryId);
    //deleteCategory
    void deleteCategory(Integer categoryId);
}
