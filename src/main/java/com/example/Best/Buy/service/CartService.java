package com.example.Best.Buy.service;

import com.example.Best.Buy.dto.CartDTO;
import com.example.Best.Buy.dto.CartRequest;

import java.util.List;

public interface CartService {
    public List<CartDTO> getAllCart();

    public CartDTO save(CartRequest cartRequest);

    public void delete(Long id);

    CartDTO update(CartDTO cartDto, Long id);
}
