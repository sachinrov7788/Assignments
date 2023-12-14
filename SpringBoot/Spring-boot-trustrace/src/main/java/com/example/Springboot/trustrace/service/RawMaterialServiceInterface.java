package com.example.Springboot.trustrace.service;

import com.example.Springboot.trustrace.model.RawMaterial;

import java.util.List;

public interface RawMaterialServiceInterface {

    List<RawMaterial> getAllData();
    RawMaterial getById(long _id);
    void saveData(RawMaterial r);
    void update(RawMaterial r);
    void delete(long _id);
}