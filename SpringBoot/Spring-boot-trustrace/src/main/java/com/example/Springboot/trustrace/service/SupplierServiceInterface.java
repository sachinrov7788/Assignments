package com.example.Springboot.trustrace.service;

import com.example.Springboot.trustrace.model.Suppliers;

import java.util.List;

public interface SupplierServiceInterface {

    List<Suppliers> getAllData();
    Suppliers getById(long _id);
    void saveData(Suppliers s);
    void update(Suppliers s);
    void delete(long _id);
    void updateSupplierName(String oldName,String newName);
}