package com.example.Best.Buy.service;

import com.example.Best.Buy.domain.Currency;
import com.example.Best.Buy.dto.CurrencyDTO;

import java.util.List;

public interface CurrencyService {
    CurrencyDTO saveCurrency(CurrencyDTO currencyDTO);

    List<CurrencyDTO> getCurrency();

}
