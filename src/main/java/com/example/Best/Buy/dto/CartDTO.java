package com.example.Best.Buy.dto;


import com.example.Best.Buy.domain.CartProduct;
import com.example.Best.Buy.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDTO {
    private Long id;
//    @NotNull(message = "createdAt should not be Null")
    private LocalDate createdAt;

    private User createdBy;
//    private List<CartProduct> cartProductsList;
}
