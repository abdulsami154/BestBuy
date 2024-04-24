package com.example.Best.Buy.dto;
import com.example.Best.Buy.domain.Cart;
import com.example.Best.Buy.domain.OrderDetails;
import com.example.Best.Buy.domain.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CartProductDTO {
    private Long id;
//    @NotNull(message = "amount should not be Null")
    private Double amount;
//    @NotNull(message = "quantity should not be Null")
    private Long quantity;
    private Cart cart;
    private Product product;
    private Boolean isActive;
//    private OrderDetails orderDetails;
}
