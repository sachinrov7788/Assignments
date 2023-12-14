package com.example.Springboot.trustrace.service.impl;

import com.example.Springboot.trustrace.model.RawMaterial;
import com.example.Springboot.trustrace.repository.RawMaterialRepository;
import com.example.Springboot.trustrace.service.RawMaterialServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RawMaterialService implements RawMaterialServiceInterface {

    @Autowired
    RawMaterialRepository repo;

    public List<RawMaterial> getAllData(){
        List<RawMaterial> list = new ArrayList<>();
        list = repo.findAll();
        return list;
    }

    public RawMaterial getById(long _id){
        Optional<RawMaterial> list = repo.findById(_id);
        return list.get();
    }

    public void saveData(RawMaterial r) {
        repo.save(r);
    }

    public void update(RawMaterial r) {
        repo.save(r);
    }

    public void delete(long _id) {
        repo.deleteBy_id(_id);
    }
}