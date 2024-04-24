package com.example.Best.Buy.service.impl;

import com.example.Best.Buy.domain.CartProduct;
import com.example.Best.Buy.domain.OrderDetails;
import com.example.Best.Buy.dto.OrderDetailsDTO;
import com.example.Best.Buy.repository.CartProductRepository;
import com.example.Best.Buy.repository.OrderDetailsRepository;
import com.example.Best.Buy.service.OrderDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderDetailsImplService implements OrderDetailsService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;


    @Autowired
    @Lazy
    CartProductImplService cartProductImplService;

    public OrderDetailsDTO save(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails=orderDetailsRepository.save(toDo(orderDetailsDTO));
        return toDto(orderDetails);
    }

    public List<OrderDetailsDTO> getAllOrderDetails() {
        return orderDetailsRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());

    }

    public void deleteOrderById(Long id) {
        Optional<OrderDetails> orderDetails=orderDetailsRepository.findById(id);
        if (orderDetails.isPresent()) {
            orderDetailsRepository.deleteByOrderDetailId(id);
        }else {
            throw new RuntimeException("order detail not found on this id= "+id);
        }
    }

    public Optional<OrderDetails> getAllOrderDetailsById(Long id) {
        return orderDetailsRepository.findById(id);
    }

    public boolean existById(Long id) {
        return orderDetailsRepository.existsById(id);
    }

    @Override
    public OrderDetailsDTO updateOrderDetail(OrderDetailsDTO orderDetailsDTO, Long id) {
        Optional<OrderDetails> orderDetailId = orderDetailsRepository.findById(id);
        if (orderDetailId.isPresent()) {
            OrderDetails orderDetailsUpdated = orderDetailsRepository.findById(id).orElse(null);
            orderDetailsUpdated.setCreatedAt(orderDetailsDTO.getCreatedAt());
            orderDetailsUpdated.setCartProduct(cartProductImplService.toDo(orderDetailsDTO.getCartProductDTO()));
            OrderDetails orderDetails = orderDetailsRepository.save(orderDetailsUpdated);
            return toDto(orderDetails);
        }

        throw new RuntimeException("Category not found on this id= "+id);
    }

    @Override
    public List<OrderDetailsDTO> getOrderDetailByCartId(Long cartId) {
        List<OrderDetailsDTO> orderDetailsDTOList=new ArrayList<>();
        List<OrderDetails> orderDetails=orderDetailsRepository.getOrderDetailByCartId(cartId);
        if (orderDetails.size()>0){
            for (OrderDetails orderDetail:orderDetails) {
                OrderDetailsDTO orderDetailsDTO1=new OrderDetailsDTO();
                orderDetailsDTO1.setId(orderDetail.getId());
                orderDetailsDTO1.setCartProductDTO(cartProductImplService.toDto(orderDetail.getCartProduct()));
                orderDetailsDTOList.add(orderDetailsDTO1);
            }
//            orderDetailsDTOList=orderDetails.stream().map(c->toDto(c)).collect(Collectors.toList());
        }
        return orderDetailsDTOList;

    }

    @Override
    public String orderDetailsDeleteById(Long id) {
        OrderDetails orderDetails= orderDetailsRepository.findById(id).get();
        orderDetails.setIsActive(false);
        if (orderDetails.getCartProduct().getId()!=null){
            CartProduct cartProduct= cartProductRepository.findById(orderDetails.getCartProduct().getId()).get();
            cartProduct.setIsActive(false);
            cartProductRepository.save(cartProduct);
        }
        orderDetails=orderDetailsRepository.save(orderDetails);
//        System.out.println(orderDetails);
        return "Deleted Successfully";
    }

    public OrderDetailsDTO findByCartProductId(Long id) {
        Optional<OrderDetails> orderDetails= orderDetailsRepository.findByCartProductId(id);
           if (!orderDetails.isPresent()){
               return null;
           }
       OrderDetailsDTO orderDetailsDTO=toDto(orderDetails.get());
       return orderDetailsDTO;
    }


    public OrderDetails toDo(OrderDetailsDTO orderDetailsDTO){
        return modelMapper.map(orderDetailsDTO,OrderDetails.class);
    }
    public OrderDetailsDTO toDto(OrderDetails orderDetails){
        return modelMapper.map(orderDetails ,OrderDetailsDTO.class);
    }


}
