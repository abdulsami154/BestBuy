package com.example.Best.Buy.service.impl;

import com.example.Best.Buy.domain.Category;
import com.example.Best.Buy.domain.Product;
import com.example.Best.Buy.domain.ProductImage;
import com.example.Best.Buy.domain.Vendor;
import com.example.Best.Buy.dto.ProductDTO;
import com.example.Best.Buy.dto.ProductResponse;
import com.example.Best.Buy.repository.CategoryRepository;
import com.example.Best.Buy.repository.ProductRepository;
import com.example.Best.Buy.repository.VendorRepository;
import com.example.Best.Buy.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductImplService implements ProductService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<ProductDTO> searchAllProductByName(String value) {
       return productRepository.findByName(value).stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getProduct() {
        ProductResponse productResponse=new ProductResponse();
        List<ProductResponse> productResponseList=new ArrayList<>();
        List<Product> product=productRepository.findAll();
        for (Product product1:product){
            productResponse.setId(product1.getId());
            productResponse.setCategory(product1.getCategory());
            List<ProductImage> images = new ArrayList<>();
            for (ProductImage image: product1.getProductImages()
                 ) {
                ProductImage p = new ProductImage();
                p.setImage(image.getImage());
                productResponse.setImage(p);
                images.add(p);
            }

            productResponse.setPrice(product1.getPrice());
            productResponse.setVendor(product1.getVendor());
            productResponse.setName(product1.getName());
            productResponseList.add(productResponse);

        }
        return productResponseList;
//        productResponse.setId(product.);
//        return productRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO save(ProductDTO productDto) {
        Product product=null;
        if (productDto.getCategoryId()!=null) {
            Category category = categoryRepository.findById(productDto.getCategoryId()).get();
            product = new Product();
            List<ProductImage> productImageList=new ArrayList<>();
            for (String img:productDto.getImage()) {
                ProductImage productImage=new ProductImage();
                productImage.setImage(img);
                productImageList.add(productImage);
//                product.setProductImages();
            }
            product.setProductImages(productImageList);
            product.setCategory(category);
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            Vendor vendor = vendorRepository.findById(productDto.getVendorId()).get();
            if (productDto.getVendorId() != null) {
                product.setVendor(vendor);
            } else {
                System.out.println("vendor not found");
                return null;
            }
            product = productRepository.save(product);
        }
        return toDto(product);

    }


    public ProductDTO toDto(Product product){
        return modelMapper.map(product,ProductDTO.class);
    }
}
