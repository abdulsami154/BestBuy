package com.example.Best.Buy.service;

import com.example.Best.Buy.domain.Vendor;
import com.example.Best.Buy.dto.VendorDTO;

public interface VendorService {
    VendorDTO save(VendorDTO vendorDTO);

    VendorDTO checkVendor(VendorDTO vendorDTO);
}
