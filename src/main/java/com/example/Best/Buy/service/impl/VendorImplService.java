package com.example.Best.Buy.service.impl;

import com.example.Best.Buy.domain.Vendor;
import com.example.Best.Buy.dto.VendorDTO;
import com.example.Best.Buy.repository.VendorRepository;
import com.example.Best.Buy.service.VendorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorImplService implements VendorService {
    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public VendorDTO save(VendorDTO vendorDTO) {
        Vendor vendor=toDo(vendorDTO);
        vendor=vendorRepository.save(vendor);
        return toDto(vendor);

    }

    @Override
    public String checkVendor(VendorDTO vendorDTO) {
       Vendor vendor= vendorRepository.findByNameAndPassword(vendorDTO.getName(),vendorDTO.getPassword());
        System.out.println(vendor.getId().toString());
    return vendor.getId().toString();
    }

    public VendorDTO toDto(Vendor vendor){
        return modelMapper.map(vendor,VendorDTO.class);
    }
    public Vendor toDo(VendorDTO vendorDTO){
        return modelMapper.map(vendorDTO,Vendor.class);
    }
}
