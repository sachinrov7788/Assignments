package com.example.SupplyChain.SpringBoot_Project1.repository;

import com.example.SupplyChain.SpringBoot_Project1.model.Style;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StyleRepository extends MongoRepository<Style, String> {
}