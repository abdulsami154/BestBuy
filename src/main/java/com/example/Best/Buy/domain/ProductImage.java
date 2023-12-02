package com.example.Best.Buy.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "product_id",referencedColumnName = "id")
//    private Product product;
}
