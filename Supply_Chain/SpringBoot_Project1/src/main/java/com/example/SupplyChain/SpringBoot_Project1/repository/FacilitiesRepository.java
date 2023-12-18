package com.example.SupplyChain.SpringBoot_Project1.repository;

import com.example.SupplyChain.SpringBoot_Project1.model.Facilities;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FacilitiesRepository extends MongoRepository<Facilities,String> {
}
