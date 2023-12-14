package com.example.Springboot.trustrace.controller;

import com.example.Springboot.trustrace.model.Facilities;
import com.example.Springboot.trustrace.service.FacilitiesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilitiesController {

    @Autowired
    FacilitiesServiceInterface service;

    @GetMapping("/select/facilities")
    public List<Facilities> getAllFacilities(){
        return service.getAllData();
    }

    @GetMapping("/select/facilitiesbyId/{id}")
    public Facilities getById(@PathVariable("id") long id){
        return service.getById(id);

    }

    @PostMapping("/save/facilities")
    public String insert(@RequestBody Facilities f) {
        Facilities d = service.getById(f.get_id());
        if(d == null) {
            service.saveData(f);
            return "Facility not exist";
        }
        else {
            return "Inserted Successfully";
        }
    }

    @PutMapping("/update/facility")
    public String update(@RequestBody Facilities f) {
        Facilities d = service.getById(f.get_id());
        if(d == null) {
            service.update(f);
            return "Facility not exist";
        }
        else {
            return "Updated Successfully";
        }
    }

    @DeleteMapping("/delete/facility/{id}")
    public String delete(@PathVariable("id") long id) {
        Facilities d = service.getById(id);
        if(d == null) {
            service.delete(id);
            return "Facility not exist";
        }
        else {
            return "Deleted Successfully";
        }
    }

    @PutMapping("/update/facility-name")
    public String updateName(@RequestParam String oldName , @RequestParam String newName) {
        service.updateFacilityName(oldName,newName);
        return "Updated Successfully";
    }
}