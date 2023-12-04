package com.example.Best.Buy.controller;

import com.example.Best.Buy.service.impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductImageController {
    @Autowired
    ImageService imageService;
    @PostMapping("/image")
    public ResponseEntity<?> save(@RequestParam("file") MultipartFile file){
        return ResponseEntity.ok(imageService.saveToGetUrl(file));
    }
}
