package com.example.SupplyChain.SpringBoot_Project1.service.impl;

import com.example.SupplyChain.SpringBoot_Project1.model.Suppliers;
import com.example.SupplyChain.SpringBoot_Project1.repository.SuppliersRepository;
import com.example.SupplyChain.SpringBoot_Project1.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class SuppliersServiceImpl implements SuppliersService {
    @Autowired
    SuppliersRepository repo;

    public Suppliers insert(Suppliers theSuppliers){
        Suppliers newSuppliers=new Suppliers();
        try{
            newSuppliers= repo.save(theSuppliers);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return newSuppliers;
    }

    public Suppliers update(Suppliers theSuppliers){
        Suppliers newSuppliers=new Suppliers();
        try{
            newSuppliers= repo.save(theSuppliers);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return newSuppliers;
    }

    public List<Suppliers> getAllData(){
        return repo.findAll();
    }

    public Optional<Suppliers> getById(String _id){
        try {
            return repo.findById(_id);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean delete(String _id){
        try{
            repo.deleteById(_id);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}