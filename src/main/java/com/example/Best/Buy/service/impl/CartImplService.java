package com.example.Best.Buy.service.impl;

import com.example.Best.Buy.domain.Cart;
import com.example.Best.Buy.domain.User;
import com.example.Best.Buy.dto.CartDTO;
import com.example.Best.Buy.dto.CartRequest;
import com.example.Best.Buy.repository.CartRepository;
import com.example.Best.Buy.repository.UserRepository;
import com.example.Best.Buy.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartImplService implements CartService {
    ModelMapper modelMapper;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;


    public List<CartDTO> getAllCart() {
        return cartRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    public CartDTO save(CartRequest cartRequest) {
        CartDTO cartDTO=null;
//        System.out.println(cartDto);
        User user=userRepository.findByIds(cartRequest.getCreatedBy());
//        User user1=user.get();
            if (user!=null) {

                Cart cart = new Cart();
                cart.setId(null);
                cart.setCreatedBy(user);
                cart = cartRepository.save(cart);
                cartDTO = new CartDTO();
                cartDTO.setId(cart.getId());
                cartDTO.setCreatedBy(cart.getCreatedBy());
            }
        return cartDTO;
    }

    public void delete(Long id) {
        Optional<Cart> cart=cartRepository.findById(id);
        if (cart.isPresent()) {
            cartRepository.deleteById(id);
        }else {
//            throw new RecordNotFoundException("Record not found in this id= "+id);
        }
    }

    public CartDTO update(CartDTO cartDto, Long id) {
        Optional<Cart> cartId=cartRepository.findById(id);
        if (cartId.isPresent()){
            Cart cartUpdated = cartRepository.findById(id).orElse(null);
            cartUpdated.setCreatedAt(cartDto.getCreatedAt());
            cartUpdated.setCreatedBy(cartDto.getCreatedBy());
            Cart cart=cartRepository.save(cartUpdated);
            return toDto(cart);
        }
        throw new RuntimeException("Cart not found on this id= "+id);
    }
    public Cart toDo(CartDTO CartDto) {
        return modelMapper.map(CartDto, Cart.class);
    }

    public CartDTO toDto(Cart cart) {
        return modelMapper.map(cart, CartDTO.class);
    }
}
