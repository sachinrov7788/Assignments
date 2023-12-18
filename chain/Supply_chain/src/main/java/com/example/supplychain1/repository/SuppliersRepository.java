package com.example.supplychain1.repository;

import com.example.supplychain1.model.Suppliers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuppliersRepository extends MongoRepository<Suppliers,Long> {
}
