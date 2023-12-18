package com.example.supplychain1.service.impl;

import com.example.supplychain1.model.Suppliers;
import com.example.supplychain1.repository.SuppliersRepository;
import com.example.supplychain1.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class SuppliersServiceImpl implements SuppliersService {
    @Autowired
    SuppliersRepository repo;

    public void save(Suppliers theSuppliers){
        repo.save(theSuppliers);
    }

    public void update(Suppliers theSuppliers){
        repo.save(theSuppliers);
    }

    public List<Suppliers> getAllData(){
        return repo.findAll();
    }

    public Optional<Suppliers> getById(long _id){
        return repo.findById(_id);
    }

    public void delete(long _id){
        repo.deleteById(_id);
    }
}
