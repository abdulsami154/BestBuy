package com.example.Best.Buy.dto;

//import com.example.ecom.domain.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {
    private Long id;
//    @NotBlank(message = "name should not be blank")
    private String name;
//    @NotNull(message = "createdAt should not be Null")
    private LocalDate createdAt;

    private List<ProductDTO> product;
}
