package com.example.Best.Buy.dto;

import com.example.Best.Buy.domain.CartProduct;
import com.example.Best.Buy.domain.Category;
import com.example.Best.Buy.domain.ProductImage;
import com.example.Best.Buy.domain.Vendor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private Long price;
    private LocalDate createdAt;
    private Category category;
    private Vendor vendor;
    private ProductImage image;
}
