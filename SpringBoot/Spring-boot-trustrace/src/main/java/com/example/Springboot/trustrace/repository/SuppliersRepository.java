package com.example.Springboot.trustrace.repository;

import com.example.Springboot.trustrace.model.Suppliers;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SuppliersRepository extends MongoRepository<Suppliers,Long> {

    void deleteBy_id(long _id);

    List<Suppliers> findBy_id(long _id);

}
