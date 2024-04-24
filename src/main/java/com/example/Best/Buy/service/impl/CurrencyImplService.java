package com.example.Best.Buy.service.impl;

import com.example.Best.Buy.domain.ConversionCurrency;
import com.example.Best.Buy.domain.Currency;
import com.example.Best.Buy.dto.ConversionCurrencyDTO;
import com.example.Best.Buy.dto.CurrencyDTO;
import com.example.Best.Buy.repository.CurrencyRepository;
import com.example.Best.Buy.service.CurrencyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyImplService implements CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public CurrencyDTO saveCurrency(CurrencyDTO currencyDTO) {
         Currency currency=currencyRepository.save(toDo(currencyDTO));
         return toDto(currency);
    }

    @Override
    public List<CurrencyDTO> getCurrency() {
        return currencyRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    public CurrencyDTO toDto(Currency currency){
        return modelMapper.map(currency,CurrencyDTO.class);
    }

    public Currency toDo(CurrencyDTO currencyDTO){
        return modelMapper.map(currencyDTO,Currency.class);
    }
}
