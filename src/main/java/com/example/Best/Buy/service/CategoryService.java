package com.example.Best.Buy.service;

import com.example.Best.Buy.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    public CategoryDTO save(CategoryDTO categoryDto);

    public List<CategoryDTO> getAllCategory();

    public void deleteCategory(Long id);

//    public Optional<Category> getAllCategoryById(Long id) {
//        return categoryRepository.findById(id);
//    }

    public CategoryDTO update(CategoryDTO categoryDto, Long id);
}
