package com.example.Springboot.trustrace.service.impl;

import com.example.Springboot.trustrace.dao.DaoInterface;
import com.example.Springboot.trustrace.model.Facilities;
import com.example.Springboot.trustrace.repository.FacilitiesRepository;
import com.example.Springboot.trustrace.service.FacilitiesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacilitiesService implements FacilitiesServiceInterface {

    @Autowired
    FacilitiesRepository repo;

    @Autowired
    DaoInterface dao;

    public List<Facilities> getAllData(){
        List<Facilities> list = new ArrayList<>();
        list = repo.findAll();
        return list;
    }

    public Facilities getById(long _id){
        Optional<Facilities> list = repo.findById(_id);
        return list.get();
    }

    public void saveData(Facilities f) {
        repo.save(f);
    }

    public void update(Facilities f) {
        repo.save(f);
    }

    public void delete(long _id) {
        repo.deleteBy_id(_id);
    }

    public void updateFacilityName(String oldName, String newName) {
        dao.facilityNameUpdate(oldName, newName);
    }
}