package com.example.Best.Buy.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate createdAt;

    @OneToOne
    @JoinColumn(name = "cartProduct_id",referencedColumnName = "id")
    private CartProduct cartProduct;

}


//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id",referencedColumnName = "id")
//    private User user;
//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
