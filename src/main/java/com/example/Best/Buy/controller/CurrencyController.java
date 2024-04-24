package com.example.Best.Buy.controller;

import com.example.Best.Buy.dto.CurrencyDTO;
import com.example.Best.Buy.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @PostMapping("/currency/save")
    public ResponseEntity<?> saveCurrency(@RequestBody CurrencyDTO currencyDTO){
        return ResponseEntity.ok(currencyService.saveCurrency(currencyDTO));
    }

    @GetMapping("/currency/get")
    public ResponseEntity<?> getCurrency(){
        return ResponseEntity.ok(currencyService.getCurrency());
    }
}
