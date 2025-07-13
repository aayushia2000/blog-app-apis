package com.ag.blog_app_apis.services.Impl;

import com.ag.blog_app_apis.entities.Category;
import com.ag.blog_app_apis.exceptions.ResourceNotFoundException;
import com.ag.blog_app_apis.payloads.CategoryDTO;
import com.ag.blog_app_apis.payloads.CategoryResponse;
import com.ag.blog_app_apis.repositories.CategoryRepo;
import com.ag.blog_app_apis.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = this.modelMapper.map(categoryDTO, Category.class);
        Category addedCategory = this.categoryRepo.save(category);
        return this.modelMapper.map(addedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id", categoryId));

        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());

        Category updatedC = this.categoryRepo.save(category);
        return this.modelMapper.map(updatedC, CategoryDTO.class);
    }

    @Override
    public CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Category> categoryPage = this.categoryRepo.findAll(pageRequest);
        List<Category> categories = categoryPage.getContent();
        List<CategoryDTO> categoryDTOS = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDTO.class)).toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        categoryResponse.setPageNumber(categoryPage.getNumber());
        categoryResponse.setPageSize(categoryPage.getSize());
        categoryResponse.setTotalPages(categoryPage.getTotalPages());
        categoryResponse.setTotalElements(categoryPage.getTotalElements());
        categoryResponse.setLastpage(categoryPage.isLast());
        return categoryResponse;
    }

    @Override
    public CategoryDTO getCategoryById(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));

        return this.modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
    Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", "Category ID", categoryId));
    this.categoryRepo.delete(cat);
    }

    private Category dtoToCategory(CategoryDTO categoryDTO){
        return this.modelMapper.map(categoryDTO, Category.class);
    }

    private CategoryDTO categoryToDto(Category category){
        return this.modelMapper.map(category, CategoryDTO.class);
    }
}
