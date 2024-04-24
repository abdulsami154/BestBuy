package com.example.Best.Buy.service;

import com.example.Best.Buy.domain.ConversionCurrency;
import com.example.Best.Buy.dto.ConversionCurrencyDTO;

public interface ConversionCurrencyService {
    ConversionCurrencyDTO findConversionCurrRate(Long id);

}
