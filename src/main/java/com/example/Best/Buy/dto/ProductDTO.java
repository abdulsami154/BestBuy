package com.example.Best.Buy.dto;

import com.example.Best.Buy.domain.ProductImage;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductDTO {
    private Long id;
    // @NotBlank(message = "name should not be blank")
    private String name;
    // @NotNull(message = "price should not be Null")
    private Long price;
    // @NotNull(message = "category id should not be Null")
    private Long categoryId;
    private Long vendorId;
    //    private List<String> images;
//    private List<ProductImage> productImages;
    private List<String> image;

}
