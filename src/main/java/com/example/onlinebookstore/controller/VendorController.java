package com.example.onlinebookstore.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onlinebookstore.model.Vendor;
import com.example.onlinebookstore.service.VendorService;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        List<Vendor> vendors = vendorService.getAllVendors();
        return new ResponseEntity<>(vendors, HttpStatus.OK);
    }

    @GetMapping("/{vendorId}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable String vendorId) {
        Vendor vendor = vendorService.getVendorById(vendorId);
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor newVendor) {
        Vendor vendor = vendorService.createVendor(newVendor);
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    }

    @PutMapping("/{vendorId}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable String vendorId, @RequestBody Vendor updatedVendor) {
        Vendor vendor = vendorService.updateVendor(vendorId, updatedVendor);
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    }

    @DeleteMapping("/{vendorId}")
    public ResponseEntity<String> deleteVendor(@PathVariable String vendorId) {
        String vendor = vendorService.deleteVendor(vendorId);
        return new ResponseEntity<>(vendor, HttpStatus.OK);
} 
}
