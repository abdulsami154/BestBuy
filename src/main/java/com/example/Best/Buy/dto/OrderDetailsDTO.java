package com.example.Best.Buy.dto;

import com.example.Best.Buy.domain.CartProduct;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailsDTO {
    private Long id;
//    @NotNull(message = "createdAt should not be Null")
    private LocalDate createdAt;
    private CartProduct cartProduct;
}
