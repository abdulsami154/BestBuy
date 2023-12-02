package com.example.Best.Buy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import jakarta.persistence;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long price;
        private LocalDate createdAt;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    @JsonIgnore
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartProduct> cartProduct;

    @ManyToOne
    @JoinColumn(name = "vendor_id" ,referencedColumnName = "id")
    private Vendor vendor;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "p_id", referencedColumnName = "id")
    private List<ProductImage> productImages;

}
