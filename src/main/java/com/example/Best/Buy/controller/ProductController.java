package com.example.Best.Buy.controller;

import com.example.Best.Buy.dto.ProductDTO;
import com.example.Best.Buy.dto.ProductResponse;
import com.example.Best.Buy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/product/search/{value}")
    public ResponseEntity<?> searchAllProductByName(@PathVariable String value){
        return ResponseEntity.ok(productService.searchAllProductByName(value));
    }

    @GetMapping("/product")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.getProduct());
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDto){
        return ResponseEntity.ok(productService.save(productDto));
    }


}
