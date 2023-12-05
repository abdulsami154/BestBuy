package com.example.Best.Buy.controller;

import com.example.Best.Buy.dto.CategoryDTO;
import com.example.Best.Buy.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> save( @RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.save(categoryDTO));
    }
    @GetMapping("/category")
    public List<CategoryDTO> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDto,@PathVariable Long id){
        return ResponseEntity.ok(categoryService.update(categoryDto,id));
    }
}
