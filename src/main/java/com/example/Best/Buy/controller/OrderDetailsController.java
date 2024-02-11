package com.example.Best.Buy.controller;

import com.example.Best.Buy.dto.OrderDetailsDTO;
import com.example.Best.Buy.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrderDetailsController {
    @Autowired
    OrderDetailsService orderDetailsService;

    @GetMapping("/orderDetails")
    public ResponseEntity<List<OrderDetailsDTO>> getAllDetails(){
        return ResponseEntity.ok(orderDetailsService.getAllOrderDetails());
    }
    @GetMapping("/orderDetailsByCartId")
    public ResponseEntity<List<OrderDetailsDTO>> getOrderDetailByCartId(@RequestParam("cartId") Long cartId){
        return ResponseEntity.ok(orderDetailsService.getOrderDetailByCartId(cartId));
    }
    @PostMapping("/orderDetails")
    public ResponseEntity<OrderDetailsDTO> save(@RequestBody OrderDetailsDTO orderDetailsDTO){
        return ResponseEntity.ok(orderDetailsService.save(orderDetailsDTO));
    }
    @DeleteMapping("/orderDetails/{id}")
    public void deleteOrderDetails(@PathVariable Long id){
        orderDetailsService.deleteOrderById(id);

    }

    @PutMapping("/orderDetails/{id}")
    public ResponseEntity<OrderDetailsDTO> updateOrderDetails(@PathVariable Long id,@RequestBody OrderDetailsDTO orderDetailsDto){
        return ResponseEntity.ok(orderDetailsService.updateOrderDetail(orderDetailsDto,id));
    }

    @DeleteMapping("/orderDetails/delete/{id}")
    public ResponseEntity<?> orderDetailsDeleteById(@PathVariable Long id){
        return ResponseEntity.ok(orderDetailsService.orderDetailsDeleteById(id));
    }

}

