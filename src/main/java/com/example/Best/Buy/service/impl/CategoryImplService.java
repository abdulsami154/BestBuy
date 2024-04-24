package com.example.Best.Buy.service.impl;

import com.example.Best.Buy.domain.Category;
import com.example.Best.Buy.dto.CategoryDTO;
import com.example.Best.Buy.repository.CategoryRepository;
import com.example.Best.Buy.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryImplService implements CategoryService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(toDo(categoryDTO));
        return  toDto(category);
    }

//    public List<CategoryDTO> getAllCategory() {
//        return categoryRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
//    }

    public List<CategoryDTO> getAllCategory(){
        return categoryRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> category=categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
        }else {
//            throw new RecordNotFoundException("Category not found on this id= "+id);
        }
    }


    public CategoryDTO update(CategoryDTO categoryDto, Long id) {
        Optional<Category> categoryId=categoryRepository.findById(id);
        if (categoryId.isPresent()){
            Category categoryUpdated=categoryRepository.findById(id).orElse(null);
            categoryUpdated.setName(categoryDto.getName());
            categoryUpdated.setCreatedAt(categoryDto.getCreatedAt());
            Category category= categoryRepository.save(categoryUpdated);
            return toDto(category);
        }
        throw new RuntimeException("Category not found on this id= "+id);
    }

    @Override
    public Long getCategoryCount() {
        return categoryRepository.count();
    }

    public Category toDo(CategoryDTO categoryDTO){
        return modelMapper.map(categoryDTO,Category.class);
    }
    public CategoryDTO toDto(Category category){
        return modelMapper.map(category ,CategoryDTO.class);
    }

}
