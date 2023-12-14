package com.example.Springboot.trustrace.controller;

import com.example.Springboot.trustrace.model.Style;
import com.example.Springboot.trustrace.service.StyleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/style")
public class StyleController {

    @Autowired
    StyleServiceInterface service;

    @GetMapping("/test")
    public String display() {
        return "hihello";
    }

    @GetMapping("/select-style")
    public List<Style> select() {
        return service.getAllStyle();
    }

    @GetMapping("/select/stylebyId/{id}")
    public Style selectById(@PathVariable("id") long id){
        return service.getById(id);

    }

    @PostMapping("/add/style")
    public String insert(@RequestBody Style s) {
        Style d = service.getById(s.get_id());
        //boolean check = service.addData(s);

        if(d == null) {
            service.addData(s);
            return "Style not exist";
        }
        else {
            return "Style already exist";
        }
//		boolean check = service.addData(s);
//
//		if(check == true)
//		    return "Inserted Successfully";
//
//		else
//			return "Style already exist";
    }

    @PutMapping("/update/style")
    public String update(@RequestBody Style s) {
        Style d = service.getById(s.get_id());
        if(d == null) {
            service.updateData(s);
            return "Style not exist";
        }
        else {
            return "Updated Successfully";
        }
    }

    @DeleteMapping("/delete/style/{id}")
    public String deleteById(@PathVariable("id") long id) {
        Style d = service.getById(id);
        if(d == null) {
            service.deleteData(id);
            return "Style not exist";
        }
        else {
            return "Deleted Successfully";
        }
    }

    @GetMapping("/select/style/dao")
    public List<Style> getData(){
        return service.getAllData();
    }

    @DeleteMapping("/delete/stylebyId/{id}")
    public String deleteId(@PathVariable ("id") long id) {
        Style d = service.getById(id);
        if(d == null) {
            service.deleteData(id);
            return "Style not exist";
        }
        else {
            return "Deleted Successfully";
        }
    }
}