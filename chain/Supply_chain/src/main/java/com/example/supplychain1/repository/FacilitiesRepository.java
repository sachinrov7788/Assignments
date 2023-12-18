package com.example.supplychain1.repository;

import com.example.supplychain1.model.Facilities;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FacilitiesRepository extends MongoRepository<Facilities,Long> {
}
