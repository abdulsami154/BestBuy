package com.example.Best.Buy.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ConversionCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Currency isMainCurrency;
    @ManyToOne
    private Currency conversionCurrency;
    private Double convertedAmount;

}
