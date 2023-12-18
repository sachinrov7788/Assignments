package com.example.supplychain1.service;

import com.example.supplychain1.model.Facilities;

import java.util.List;
import java.util.Optional;

public interface FacilitiesService {
    void save(Facilities theFacilities);
    void update(Facilities theFacilities);
    void delete(long id);
    List<Facilities> getAllData();
    Optional<Facilities> getById(long id);
}
