package com.example.Best.Buy.dto;

import com.example.Best.Buy.domain.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    // @NotBlank(message = "name should not be blank")
    private String name;
    // @NotNull(message = "price should not be Null")
    private Long price;
    // @NotNull(message = "category id should not be Null")
    private Long categoryId;
    //    private List<String> images;
    private List<ProductImage> productImages;

}
