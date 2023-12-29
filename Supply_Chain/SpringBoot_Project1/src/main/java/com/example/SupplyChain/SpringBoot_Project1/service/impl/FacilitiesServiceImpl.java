package com.example.SupplyChain.SpringBoot_Project1.service.impl;

import com.example.SupplyChain.SpringBoot_Project1.model.Facilities;
import com.example.SupplyChain.SpringBoot_Project1.repository.FacilitiesRepository;
import com.example.SupplyChain.SpringBoot_Project1.service.FacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Lazy(value = true)
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

    public Optional<Facilities> getById(String _id){
        return repo.findById(_id);
    }

    public void delete(String _id){
        repo.deleteById(_id);
    }
}