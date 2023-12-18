package com.example.SupplyChain.SpringBoot_Project1.repository;

import com.example.SupplyChain.SpringBoot_Project1.model.Suppliers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuppliersRepository extends MongoRepository<Suppliers,String> {
}