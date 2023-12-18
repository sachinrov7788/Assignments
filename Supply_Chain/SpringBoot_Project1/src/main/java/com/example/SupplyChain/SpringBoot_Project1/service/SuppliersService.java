package com.example.SupplyChain.SpringBoot_Project1.service;

import com.example.SupplyChain.SpringBoot_Project1.model.Suppliers;

import java.util.List;
import java.util.Optional;

import com.example.SupplyChain.SpringBoot_Project1.model.Suppliers;

import java.util.List;
import java.util.Optional;

public interface SuppliersService {
    Suppliers insert(Suppliers theSuppliers);
    Suppliers update(Suppliers theSuppliers);
    Boolean delete(String id);
    List<Suppliers> getAllData();
    Optional<Suppliers> getById(String id);
}