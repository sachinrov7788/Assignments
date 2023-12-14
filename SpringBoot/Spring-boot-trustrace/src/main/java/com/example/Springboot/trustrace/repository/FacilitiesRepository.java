package com.example.Springboot.trustrace.repository;

import com.example.Springboot.trustrace.model.Facilities;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
public interface FacilitiesRepository extends MongoRepository<Facilities,Long> {

    List<Facilities> findBy_id(long _id);

    void deleteBy_id(long _id);

}