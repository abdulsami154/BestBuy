package com.example.Best.Buy.controller;


import com.example.Best.Buy.service.ConversionCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ConversionCurrencyController {
    @Autowired
    ConversionCurrencyService conversionCurrencyService;

    @GetMapping("/get/conversionCurrency")
    public ResponseEntity<?> getConversionCurrency(@RequestParam Long id){
       return ResponseEntity.ok(conversionCurrencyService.findConversionCurrRate(id));
    }



}
