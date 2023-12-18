package com.example.SupplyChain.SpringBoot_Project1.service;
import com.example.SupplyChain.SpringBoot_Project1.model.Facilities;

import java.util.List;
import java.util.Optional;

public interface FacilitiesService {
    void save(Facilities theFacilities);
    void update(Facilities theFacilities);
    void delete(String id);
    List<Facilities> getAllData();
    Optional<Facilities> getById(String id);
}
