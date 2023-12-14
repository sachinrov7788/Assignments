package com.example.Springboot.trustrace.repository;

import com.example.Springboot.trustrace.model.Style;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StyleRepository extends MongoRepository<Style, Long> {

    List<Style> findBy_id(long _id);

    void deleteBy_id(long id);


}