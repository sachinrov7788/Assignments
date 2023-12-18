package com.example.supplychain1.repository;

import com.example.supplychain1.model.Style;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StyleRepository extends MongoRepository<Style, Long> {
}
