package com.example.SupplyChain.SpringBoot_Project1.service;

import com.example.SupplyChain.SpringBoot_Project1.model.RawMaterial;

import java.util.List;
import java.util.Optional;

public interface RawMaterialService {
    void save(RawMaterial theRawMaterial);
    void update(RawMaterial theRawMaterial);
    void delete(String id);
    List<RawMaterial> getAllData();
    Optional<RawMaterial> getById(String _id);
}