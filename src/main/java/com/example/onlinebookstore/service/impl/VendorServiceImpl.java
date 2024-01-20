package com.example.onlinebookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.onlinebookstore.model.Vendor;
import com.example.onlinebookstore.repository.VendorRepository;
import com.example.onlinebookstore.service.VendorService;

import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public List<Vendor> getAllVendors() {
        try {
            List<Vendor> vendors = vendorRepository.findAll();
            return vendors;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Vendor getVendorById(String vendorId) {
        try {
            Vendor optionalVendor = vendorRepository.findById(vendorId).orElse(null);
            return optionalVendor;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Vendor createVendor(Vendor newVendor) {
        try{
        Vendor existingVendor = vendorRepository.findByVendorId(newVendor);

        if(existingVendor==null){
            vendorRepository.save(newVendor);
            return newVendor;
        }
        else{
            return null;
        }
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }
}

@Override
    public Vendor updateVendor(String vendorId, Vendor updatedVendor) {
        try{
        Vendor existingVendor = vendorRepository.findByVendorId(updatedVendor);

        if(existingVendor!=null){
            updatedVendor.setVendorId(existingVendor.getVendorId());
            vendorRepository.save(updatedVendor);
            return updatedVendor;
        }
        else{
            return null;
        }
    }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteVendor(String vendorId) {
        try{
        Boolean existingVendor = vendorRepository.existsByVendorId(vendorId);

        if(existingVendor){
            vendorRepository.deleteByVendorId(vendorId);
            return "Deleted Successfully";
        }
        else{
            return "VendorId not found give valid vendorId";
        }
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }
}
}

