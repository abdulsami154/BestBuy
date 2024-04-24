package com.example.Best.Buy.dto;

import com.example.Best.Buy.domain.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConversionCurrencyDTO {
    private Long id;
    private Currency isMainCurrency;
    private Currency conversionCurrency;
}
