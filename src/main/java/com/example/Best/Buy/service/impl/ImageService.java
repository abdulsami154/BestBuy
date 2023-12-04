package com.example.Best.Buy.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImageService {
    @Value("${upload.directory}")
    String uploadDirectory;
    public String saveToGetUrl(MultipartFile file) {
        Path uploadPath= Paths.get(uploadDirectory);
        try {
            String fileName=file.getOriginalFilename();
            InputStream inputStream=file.getInputStream();
            Path filePath=uploadPath.resolve(fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
            return "http://localhost:8081/api/image/"+fileName;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
