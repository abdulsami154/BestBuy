package com.example.Best.Buy.domain;

import com.example.Best.Buy.domain.CartProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate createdAt;
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User createdBy;
    private Boolean isActive;

    @JsonIgnore
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartProduct> cartProductsList;

}
