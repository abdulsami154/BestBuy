package com.example.Best.Buy.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
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
    public Resource load(String fileName){
        try {
            Path root = Paths.get(uploadDirectory);
            Path file=root.resolve(fileName);
            Resource resource =new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw new RuntimeException("Could not read file");
            }
        }catch (MalformedURLException e){
            throw new RuntimeException("Error :" +e.getMessage());
        }
    }
}
