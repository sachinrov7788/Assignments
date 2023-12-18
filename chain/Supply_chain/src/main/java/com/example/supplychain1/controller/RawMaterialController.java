package com.example.supplychain1.controller;

import com.example.supplychain1.model.RawMaterial;
import com.example.supplychain1.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rawmaterial")
public class RawMaterialController {
    @Autowired
    RawMaterialService rawMaterialService;
    @GetMapping("/alldata")
    public ResponseEntity<List<RawMaterial>> GetAllData(){
        try{
            return new ResponseEntity<List<RawMaterial>>(rawMaterialService.getAllData(),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/databyid/{_id}")
    public ResponseEntity<Optional<RawMaterial>> GetById(@PathVariable long _id){
        try{
            return new ResponseEntity<Optional<RawMaterial>>(rawMaterialService.getById(_id),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<String> InsertData(@RequestBody RawMaterial theRawMaterial){
        try{
            rawMaterialService.save(theRawMaterial);
            return new ResponseEntity<String> ("Document inserted successfully", HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String> ("Internal Error", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> UpdateData(@RequestBody RawMaterial theRawMaterial){
        try{
            rawMaterialService.save(theRawMaterial);
            return new ResponseEntity<String>("Updated document successfully",HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>( "Internal error",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{_id}")
    public ResponseEntity<String> delete(@PathVariable long _id){
        try {
            if (rawMaterialService.getById((_id)).isPresent()) {
                rawMaterialService.delete(_id);
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
