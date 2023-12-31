package com.example.SupplyChain.SpringBoot_Project1.controller;

import com.example.SupplyChain.SpringBoot_Project1.model.Facilities;
import com.example.SupplyChain.SpringBoot_Project1.service.FacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facilities")
public class FacilitiesController {

    @Autowired
    FacilitiesService facilitiesService;
    @GetMapping("/alldata")
    public ResponseEntity<List<Facilities>> GetAllData(){
        try{
            return new ResponseEntity<List<Facilities>>(facilitiesService.getAllData(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/databyid/{_id}")
    public ResponseEntity<Optional<Facilities>> GetById(@PathVariable String _id){
        try{
            return new ResponseEntity<Optional<Facilities>>(facilitiesService.getById(_id),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<String> InsertData(@RequestBody Facilities theFacilities){
        try{
            facilitiesService.save(theFacilities);
            return new ResponseEntity<String> ("Document inserted successfully", HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String> ("Internal Error", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> UpdateData(@RequestBody Facilities theFacilities){
        try{
            facilitiesService.save(theFacilities);
            return new ResponseEntity<String>("Updated document successfully",HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>( "Internal error",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{_id}/{Path}")
    public ResponseEntity<String> delete(@PathVariable("_id") String id,@PathVariable String Path){
        try {
            if (facilitiesService.getById((id)).isPresent()) {
                facilitiesService.delete(id);
                return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
            }
            else{
                return new ResponseEntity<String>( "Id not found",HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            return new ResponseEntity<String>("Internal error",HttpStatus.BAD_REQUEST);
        }
    }
}