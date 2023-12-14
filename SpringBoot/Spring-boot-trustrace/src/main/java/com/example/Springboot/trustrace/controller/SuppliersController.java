package com.example.Springboot.trustrace.controller;

import com.example.Springboot.trustrace.model.Suppliers;
import com.example.Springboot.trustrace.service.SupplierServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

    @Autowired
    SupplierServiceInterface service;

    @GetMapping("/select/suppliers")
    public List<Suppliers> getAllData(){
        return service.getAllData();
    }

    @GetMapping("/select/suppliersbyId/{id}")
    public Suppliers getById(@PathVariable("id") long id){
        return service.getById(id);

    }

    @PostMapping("/save/suppliers")
    public String insert(@RequestBody Suppliers s) {
        Suppliers d = service.getById(s.get_id());
        if(d == null) {
            service.saveData(s);
            return "Supplier not exist";
        }
        else {
            return "Inserted Successfully";
        }
    }

    @PutMapping("/update/supplier")
    public String update(@RequestBody Suppliers s) {
        Suppliers d = service.getById(s.get_id());
        if(d == null) {
            service.update(s);
            return "Supplier not exist";
        }
        else {
            return "Updated Successfully";
        }
    }

    @DeleteMapping("/delete/supplier/{id}")
    public String delete(@PathVariable("id") long id) {
        Suppliers d = service.getById(id);
        if(d == null) {
            service.delete(id);
            return "Supplier not exist";
        }
        else {
            return "Deleted Successfully";
        }
    }

    @PutMapping("/update/supplier-name")
    public String updateName(@RequestParam String oldName , @RequestParam String newName) {
        service.updateSupplierName(oldName, newName);
        return "Updated Name Successfully";
    }
}