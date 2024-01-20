package com.example.onlinebookstore.service;
import org.springframework.http.ResponseEntity;

import com.example.onlinebookstore.model.Vendor;

import java.util.List;

public interface VendorService {

    List<Vendor> getAllVendors();

    Vendor getVendorById(String vendorId);

    Vendor createVendor(Vendor newVendor);

    Vendor updateVendor(String vendorId, Vendor updatedVendor);

    String deleteVendor(String vendorId);
}