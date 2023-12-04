package com.example.Best.Buy.service;

import com.example.Best.Buy.dto.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<ProductDTO> searchAllProductByName(String value);

    List<ProductDTO> getProduct();

    ProductDTO save(ProductDTO productDto);
}
