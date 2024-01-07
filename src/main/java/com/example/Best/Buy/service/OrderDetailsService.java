package com.example.Best.Buy.service;

import com.example.Best.Buy.domain.OrderDetails;
import com.example.Best.Buy.dto.OrderDetailsDTO;

import java.util.List;
import java.util.Optional;

public interface OrderDetailsService {
     OrderDetailsDTO save(OrderDetailsDTO orderDetailsDTO);

     List<OrderDetailsDTO> getAllOrderDetails();

     void deleteOrderById(Long id);

//     Optional<OrderDetails> getAllOrderDetailsById(Long id);
//    public boolean existById(Long id);

    OrderDetailsDTO updateOrderDetail(OrderDetailsDTO orderDetailsDTO,Long id);

}
