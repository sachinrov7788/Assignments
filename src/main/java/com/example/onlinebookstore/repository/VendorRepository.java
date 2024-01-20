package com.example.onlinebookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.onlinebookstore.model.Vendor;

public interface VendorRepository extends MongoRepository<Vendor, String> {

    Vendor findByVendorId(Vendor newVendor);

    Boolean existsByVendorId(String vendorId);

    String deleteByVendorId(String vendorId);

    
}
