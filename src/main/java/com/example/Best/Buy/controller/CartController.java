package com.example.Best.Buy.controller;

import com.example.Best.Buy.dto.CartDTO;
import com.example.Best.Buy.dto.CartRequest;
import com.example.Best.Buy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    CartService cartService;
    @GetMapping("/cart")
    public ResponseEntity<List<CartDTO>> getAllCart(){
        return ResponseEntity.ok(cartService.getAllCart());
    }
    @PostMapping("/cart")
    public ResponseEntity<CartDTO> save(@RequestBody CartRequest cartRequest){
        return ResponseEntity.ok(cartService.save(cartRequest));
    }
    @DeleteMapping("/cart/{id}")
    public void deleteCart(@PathVariable Long id){
        cartService.delete(id);
    }
    @PutMapping("/cart/{id}")
    public ResponseEntity<CartDTO> updateCart(@RequestBody CartDTO cartDto,@PathVariable Long id) {
        return ResponseEntity.ok(cartService.update(cartDto, id));
    }
}
