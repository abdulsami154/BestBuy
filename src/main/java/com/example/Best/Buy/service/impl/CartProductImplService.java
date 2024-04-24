package com.example.Best.Buy.service.impl;

import com.example.Best.Buy.domain.*;
import com.example.Best.Buy.dto.CartProductDTO;
import com.example.Best.Buy.dto.CartProductRequest;
import com.example.Best.Buy.dto.OrderDetailsDTO;
import com.example.Best.Buy.repository.*;
import com.example.Best.Buy.service.CartProductService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CartProductImplService implements CartProductService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderDetailsImplService orderDetailsImplService;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;


    public List<CartProductDTO> getAllCartProduct() {
        return cartProductRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public CartProductDTO updateCartProduct(CartProductDTO cartProductDto, Long id) {
        Optional<CartProduct> cartProduct1 = cartProductRepository.findById(id);
        CartProduct cartProduct=null;
        if(cartProduct1.isPresent()){
            cartProduct1.get().setProduct(cartProductDto.getProduct());
            cartProduct1.get().setCart(cartProductDto.getCart());
            cartProduct1.get().setAmount(cartProductDto.getAmount());
            cartProduct1.get().setQuantity(cartProductDto.getQuantity());
             cartProduct = cartProductRepository.save(cartProduct1.get());
            return toDto(cartProduct);
        }
//        throw new RecordNotFoundException(String.format("Cart-Product doesn't exist on this id ==> %d",id));
        return toDto(cartProduct);
    }

    @Override
    public List<CartProductDTO> getAllCartProductById(Long id) {
        return cartProductRepository.findAllCartByid(id).stream().map(c->toDto(c)).collect(Collectors.toList());
    }

//    Logger logger = LoggerFactory.getLogger(CartProductService.class);


    public CartProductDTO save(CartProductRequest cartProductRequest) {
        CartProductDTO cartProductDTO=new CartProductDTO();
        Cart cart =cartRepository.findByIds(cartProductRequest.getCartId());
        System.out.println();
        CartProduct cartProduct=null;
        Product product=productRepository.findByIds(cartProductRequest.getProductId());
        List<CartProduct> cartProduct1=cartProductRepository.findByMultipleIds(cart.getId(),product.getId());
        if (cartProduct1.size()>0){
            for (CartProduct cartproduct2:cartProduct1) {
                cartProductDTO.setId(cartproduct2.getId());
                cartProductDTO.setProduct(product);
                cartProductDTO.setCart(cart);
                cartProductDTO.setIsActive(true);
                Long quantity=cartproduct2.getQuantity();
                quantity+=1;
                cartProductDTO.setQuantity(quantity);
                cartProductDTO.setAmount(product.getPrice().doubleValue());
            }
//            cartProductDTO.setId(cartProduct1.get);
//            cartProductDTO.setProduct(product);
//            cartProductDTO.setCart(cart);
//            Long quantity=cartProductRequest.getQuantity();
//            quantity++;
//            cartProductDTO.setQuantity(quantity);
//            cartProductDTO.setAmount(product.getPrice().doubleValue());
        }else {
            cartProductDTO.setProduct(product);
            cartProductDTO.setCart(cart);
            cartProductDTO.setIsActive(true);
            cartProductDTO.setQuantity(cartProductRequest.getQuantity());
            cartProductDTO.setAmount(product.getPrice().doubleValue());
        }
        cartProduct=cartProductRepository.save(toDo(cartProductDTO));

        return toDto(cartProduct);
    }

    @Override
    public List<CartProductDTO> updateCartProducts(List<CartProductRequest> cartProductRequest) {
        List<CartProductDTO> cartProductDTOList=new ArrayList<>();
        OrderDetailsDTO orderDetailsDTO=null;
        OrderDetails orderDetails=null;
        for (CartProductRequest cartProductRequest1 :cartProductRequest) {
            CartProduct cartProduct=cartProductRepository.findCartProductById(cartProductRequest1.getId());
            if (cartProduct!=null){
                cartProduct.setQuantity(cartProductRequest1.getQuantity());
            }
            cartProduct=cartProductRepository.save(cartProduct);
            CartProductDTO cartProductDTO= toDto(cartProduct);
            cartProductDTOList.add(cartProductDTO);
            if (cartProductDTO!=null) {
                orderDetailsDTO = orderDetailsImplService.findByCartProductId(cartProduct.getId());
                if (orderDetailsDTO == null) {
                    orderDetails=new OrderDetails();
                    orderDetails.setCartProduct(cartProduct);
                    orderDetails.setIsActive(true);
                    orderDetailsRepository.save(orderDetails);
                }
            }
        }
        return cartProductDTOList;
    }


    public void deleteById(Long id) {
        Optional<CartProduct> cartProduct=cartProductRepository.findById(id);
        if (cartProduct.isPresent()){
            cartProductRepository.deleteById(id);
        }
//        else {
//            throw new RecordNotFoundException("Cart Product not found on this id= "+id);
//        }
    }

    public CartProduct toDo(CartProductDTO cartProductDTO){
        return modelMapper.map(cartProductDTO,CartProduct.class);
    }
    public CartProductDTO toDto(CartProduct CartProduct){
        return modelMapper.map(CartProduct ,CartProductDTO.class);
    }

}

