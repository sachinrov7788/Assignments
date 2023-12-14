package com.example.Springboot.trustrace.service;

import com.example.Springboot.trustrace.model.Facilities;

import java.util.List;

public interface FacilitiesServiceInterface {

    List<Facilities> getAllData();
    Facilities getById(long _id);
    void saveData(Facilities f);
    void update(Facilities f);
    void delete(long _id);
    void updateFacilityName(String oldName, String newName);
}