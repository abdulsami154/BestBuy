package com.example.Best.Buy.controller;

import com.example.Best.Buy.dto.CartProductDTO;
import com.example.Best.Buy.dto.CartProductRequest;
import com.example.Best.Buy.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CartProductController {
    @Autowired(required = false)
    CartProductService cartProductService;
    @GetMapping("/cartProduct")
    public List<CartProductDTO> getAllCartProduct(){
        return cartProductService.getAllCartProduct();
    }

    @GetMapping("/cartProduct/{id}")
    public ResponseEntity<List<CartProductDTO>> getAllCartProduct(@PathVariable Long id){
        return ResponseEntity.ok(cartProductService.getAllCartProductById(id));
    }

    @PostMapping("/cartProduct")
    public ResponseEntity<CartProductDTO> save(@RequestBody CartProductRequest cartProductRequest){
        return ResponseEntity.ok(cartProductService.save(cartProductRequest));
    }

    @PostMapping("/update/cartProduct")
    public ResponseEntity<?> updateCartProducts(@RequestBody List<CartProductRequest> cartProductRequest){
        return ResponseEntity.ok(cartProductService.updateCartProducts(cartProductRequest));
    }

    @DeleteMapping("/cartProduct/{id}")
    public void deleteCartProduct(@PathVariable Long id){
        cartProductService.deleteById(id);
    }



    @PutMapping("/cartProduct/{id}")
    public ResponseEntity<CartProductDTO> updateCartProduct( @PathVariable Long id, @RequestBody CartProductDTO cartProductDto){
        return ResponseEntity.ok(cartProductService.updateCartProduct(cartProductDto,id));
    }
}
