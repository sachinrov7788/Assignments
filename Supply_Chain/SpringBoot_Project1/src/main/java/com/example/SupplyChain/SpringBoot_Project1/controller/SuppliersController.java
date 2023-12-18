package com.example.SupplyChain.SpringBoot_Project1.controller;

import com.example.SupplyChain.SpringBoot_Project1.model.Suppliers;
import com.example.SupplyChain.SpringBoot_Project1.service.SuppliersService;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {
    @Autowired
    SuppliersService suppliersService;
    @GetMapping("/alldata")
    public ResponseEntity<List<Suppliers>> GetAllData(){
        try{
            return new ResponseEntity<List<Suppliers>>(suppliersService.getAllData(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/databyid/{_id}")
    public ResponseEntity<Optional<Suppliers>> GetById(@PathVariable String _id){
        try{
            Optional<Suppliers> storeSuppliers=suppliersService.getById(_id);
            if(suppliersService.getById((_id)).isPresent()){
                return new ResponseEntity<>(storeSuppliers,HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(Optional.of(new Suppliers()),HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(Optional.of(new Suppliers()),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Suppliers> InsertData(@RequestBody Suppliers theSuppliers){
        try{
            suppliersService.insert(theSuppliers);
            return new ResponseEntity<Suppliers> (theSuppliers, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Suppliers> (new Suppliers(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Suppliers> UpdateData(@RequestBody Suppliers theSuppliers){
        try{
            suppliersService.update(theSuppliers);
            return new ResponseEntity<Suppliers> (theSuppliers, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Suppliers> (new Suppliers(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{_id}")
    public ResponseEntity<Boolean> delete(@PathVariable String _id){
        try {
            suppliersService.delete(_id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }
}