package com.example.Best.Buy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartProductRequest {
    //    @NotNull(message = "amount should not be Null")
//    private Double amount;
    //    @NotNull(message = "quantity should not be Null")
    private Long quantity;
    private Long cartId;
    private Long productId;
}
