package com.example.Best.Buy.controller;

import com.example.Best.Buy.dto.ProductDTO;
import com.example.Best.Buy.dto.ProductResponse;
import com.example.Best.Buy.dto.VendorIdRequest;
import com.example.Best.Buy.service.ProductService;
import com.example.Best.Buy.service.impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ImageService imageService;
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

    @PostMapping("/product/vendorId")
    public ResponseEntity<?> getAllProductsById(@RequestBody VendorIdRequest vendorIdRequest){
        return ResponseEntity.ok(productService.getAllProductsByVendorId(vendorIdRequest.getId()));
    }
    @GetMapping("/product/count")
    public ResponseEntity<?> getCountTotalProducts(){
        return ResponseEntity.ok(productService.getCountTotalProducts());
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDto){
        return ResponseEntity.ok(productService.save(productDto));
    }
    @GetMapping("/image/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getFile(@PathVariable String fileName) throws IOException {
        Resource file = imageService.load(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(file.getInputStream()));
    }

//aa
}
