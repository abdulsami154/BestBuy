package com.example.Best.Buy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyDTO {
    private Long id;

    private String currencyName;
    private String currencyCode;
    private Boolean isMainCurrency;
    private Double conversionRate;
}
