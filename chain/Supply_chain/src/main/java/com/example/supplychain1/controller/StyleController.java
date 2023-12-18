package com.example.supplychain1.controller;

import com.example.supplychain1.model.Style;
import com.example.supplychain1.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/style")
public class StyleController {
    @Autowired
    StyleService styleService;

    @GetMapping("/alldata")
    public ResponseEntity<List<Style>> GetAllData(){
        try{
            return new ResponseEntity<List<Style>>(styleService.getAllData(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/databyid/{_id}")
    public ResponseEntity<Optional<Style>> GetById(@PathVariable long _id){
        try{
            return new ResponseEntity<Optional<Style>>(styleService.getById(_id),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<String> InsertData(@RequestBody Style theStyle){
        try{
            styleService.save(theStyle);
            return new ResponseEntity<String> ("Document inserted successfully", HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String> ("Internal Error", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> UpdateData(@RequestBody Style theStyle){
        try{
            styleService.save(theStyle);
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
            if (styleService.getById((_id)).isPresent()) {
                styleService.delete(_id);
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
