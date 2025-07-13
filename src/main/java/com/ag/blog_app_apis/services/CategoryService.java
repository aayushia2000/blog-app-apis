package com.ag.blog_app_apis.services;

import com.ag.blog_app_apis.payloads.CategoryDTO;
import com.ag.blog_app_apis.payloads.CategoryResponse;

import java.util.List;

public interface CategoryService {
    //create
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    //update
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);
    //getAllCategory
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize);
    //getCategoryById
    CategoryDTO getCategoryById(Integer categoryId);
    //deleteCategory
    void deleteCategory(Integer categoryId);
}
