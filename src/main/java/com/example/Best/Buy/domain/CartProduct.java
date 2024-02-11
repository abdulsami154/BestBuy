package com.example.Best.Buy.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double amount;
    private Long quantity;
    @ManyToOne
    @JoinColumn(name = "cart_id",referencedColumnName = "id")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    @Column(columnDefinition="tinyint(1) default 1")
    private Boolean isActive;

    @JsonIgnore
    @OneToOne(mappedBy = "cartProduct",cascade = CascadeType.ALL,orphanRemoval = true)
    private OrderDetails orderDetails;



}
