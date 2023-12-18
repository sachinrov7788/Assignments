package com.example.supplychain1.service.impl;

import com.example.supplychain1.model.Facilities;
//import com.example.supplychain1.repository.FacilitiesRepository;
import com.example.supplychain1.repository.FacilitiesRepository;
import com.example.supplychain1.service.FacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilitiesServiceImpl implements FacilitiesService {
    @Autowired
    FacilitiesRepository repo;

    public void save(Facilities theFacilities){
        repo.save(theFacilities);
    }

    public void update(Facilities theFacilities){
        repo.save(theFacilities);
    }

    public List<Facilities> getAllData(){
        return repo.findAll();
    }

    public Optional<Facilities> getById(long _id){
        return repo.findById(_id);
    }

    public void delete(long _id){
        repo.deleteById(_id);
    }
}
