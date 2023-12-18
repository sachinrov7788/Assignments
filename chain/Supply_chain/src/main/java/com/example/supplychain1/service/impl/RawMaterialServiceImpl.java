package com.example.supplychain1.service.impl;

import com.example.supplychain1.model.RawMaterial;
import com.example.supplychain1.repository.RawMaterialRepository;
import com.example.supplychain1.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RawMaterialServiceImpl implements RawMaterialService {
    @Autowired
    RawMaterialRepository repo;

    public void save(RawMaterial theRawMaterial){
        repo.save(theRawMaterial);
    }

    public void update(RawMaterial theRawMaterial){
        repo.save(theRawMaterial);
    }

    public List<RawMaterial> getAllData(){
        List<RawMaterial> theDetails=new ArrayList<>();
        theDetails=repo.findAll();
        return theDetails;
    }

    public Optional<RawMaterial> getById(long _id){
        return repo.findById(_id);
    }

    public void delete(long _id){
        repo.deleteById(_id);
    }

}
