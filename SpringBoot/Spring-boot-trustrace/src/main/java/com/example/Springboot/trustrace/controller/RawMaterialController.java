package com.example.Springboot.trustrace.controller;

import com.example.Springboot.trustrace.model.RawMaterial;
import com.example.Springboot.trustrace.service.RawMaterialServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rawmaterial")
public class RawMaterialController {

    @Autowired
    RawMaterialServiceInterface service;

    @GetMapping("/select/rawmaterial")
    public List<RawMaterial> getAllData(){
        return service.getAllData();
    }

    @GetMapping("/select/rawmaterialbyId/{id}")
    public RawMaterial getById(@PathVariable("id") long id){
        return service.getById(id);

    }

    @PostMapping("/save/rawmaterial")
    public String insert(@RequestBody RawMaterial r) {
        service.saveData(r);
        return "Inserter Successfully";
    }

    @PutMapping("/update/rawmaterial")
    public String update(@RequestBody RawMaterial r) {
        service.update(r);
        return "Updated Successfully";
    }

    @DeleteMapping("/delete/rawmaterial/{id}")
    public String delete(@PathVariable long id) {
    service.delete(id);
    return "deleted Successfully";
    }
}