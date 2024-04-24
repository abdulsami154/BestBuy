package com.example.Best.Buy.service;

import com.example.Best.Buy.dto.ProductDTO;
import com.example.Best.Buy.dto.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<ProductResponse> searchAllProductByName(String value);

    List<ProductResponse> getProduct();

    ProductDTO save(ProductDTO productDto);

    Long getCountTotalProducts();

    List<ProductResponse> getAllProductsByVendorId(Long vendorId);

    List<ProductResponse> getProductsByCategoryId(Long id);

    List<ProductResponse> getProductByPageSize(Long currentPage,Long pageSize);
}
