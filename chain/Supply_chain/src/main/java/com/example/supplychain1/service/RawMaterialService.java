package com.example.supplychain1.service;

import com.example.supplychain1.model.RawMaterial;

import java.util.List;
import java.util.Optional;

public interface RawMaterialService {
    void save(RawMaterial theRawMaterial);
    void update(RawMaterial theRawMaterial);
    void delete(long id);
    List<RawMaterial> getAllData();
    Optional<RawMaterial> getById(long _id);
}
