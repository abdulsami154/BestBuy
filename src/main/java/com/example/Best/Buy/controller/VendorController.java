package com.example.Best.Buy.controller;

import com.example.Best.Buy.dto.VendorDTO;
import com.example.Best.Buy.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class VendorController {
    @Autowired
    VendorService vendorService;
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody VendorDTO vendorDTO){
        return ResponseEntity.ok(vendorService.save(vendorDTO));
    }
    @PostMapping("/loginVendor")
    public ResponseEntity<?> checkVendor(@RequestBody VendorDTO vendorDTO){
        return ResponseEntity.ok(vendorService.checkVendor(vendorDTO));
    }

}
