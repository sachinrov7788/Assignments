package com.example.Springboot.trustrace.repository;

import com.example.Springboot.trustrace.model.RawMaterial;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RawMaterialRepository extends MongoRepository<RawMaterial, Long> {

    List<RawMaterial> findBy_id(long _id);

    void deleteBy_id(long _id);

}
