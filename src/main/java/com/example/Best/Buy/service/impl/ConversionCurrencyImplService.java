package com.example.Best.Buy.service.impl;

import com.example.Best.Buy.domain.ConversionCurrency;
import com.example.Best.Buy.dto.ConversionCurrencyDTO;
import com.example.Best.Buy.repository.ConversionCurrencyRepository;
import com.example.Best.Buy.service.ConversionCurrencyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionCurrencyImplService implements ConversionCurrencyService {
    @Autowired
    ConversionCurrencyRepository conversionCurrencyRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public ConversionCurrencyDTO findConversionCurrRate(Long id) {
        return toDto(conversionCurrencyRepository.findByConversionCurrency(id));
    }

    public ConversionCurrencyDTO toDto(ConversionCurrency conversionCurrency){
        return modelMapper.map(conversionCurrency,ConversionCurrencyDTO.class);
    }

    public ConversionCurrency toDo(ConversionCurrencyDTO conversionCurrencyDTO){
        return modelMapper.map(conversionCurrencyDTO,ConversionCurrency.class);
    }




}
