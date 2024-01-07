package com.example.Best.Buy.service;

import com.example.Best.Buy.dto.CartProductDTO;
import com.example.Best.Buy.dto.CartProductRequest;

import java.util.List;

public interface CartProductService {
    public void deleteById(Long id);
    public List<CartProductDTO> getAllCartProduct();
//    public Optional<CartProduct> getAllCartProductById(Long id) {
//        return cartProductRepository.findById(id);
//    }

//    public boolean existById(Long id) {
//        return cartProductRepository.existsById(id);
//    }

    public CartProductDTO updateCartProduct(CartProductDTO cartProductDto, Long id);

    List<CartProductDTO> getAllCartProductById(Long id);

    public CartProductDTO save(CartProductRequest cartProductRequest);
}
