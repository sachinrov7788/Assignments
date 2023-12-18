package com.example.supplychain1.service;

import com.example.supplychain1.model.Suppliers;

import java.util.List;
import java.util.Optional;

public interface SuppliersService {
    void save(Suppliers theSuppliers);
    void update(Suppliers theSuppliers);
    void delete(long id);
    List<Suppliers> getAllData();
    Optional<Suppliers> getById(long id);
}
