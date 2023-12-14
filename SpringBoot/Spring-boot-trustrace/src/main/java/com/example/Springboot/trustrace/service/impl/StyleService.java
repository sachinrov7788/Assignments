package com.example.Springboot.trustrace.service.impl;


import com.example.Springboot.trustrace.dao.DaoInterface;
import com.example.Springboot.trustrace.model.Style;
import com.example.Springboot.trustrace.repository.StyleRepository;
import com.example.Springboot.trustrace.service.StyleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StyleService implements StyleServiceInterface {

    @Autowired
    StyleRepository repo;

    @Autowired
    DaoInterface dao;;

    public List<Style> getAllStyle(){
        List<Style> list = new ArrayList<>();
        list = repo.findAll();
        return list;
    }

    public Style getById(long _id){
//		List<style> list = repo.findBy_id(_id);
        Optional<Style> result = repo.findById(_id);
        return result.get();
    }

    public void addData(Style s) {
        repo.save(s);
    }

    public void updateData(Style s) {
        repo.save(s);
    }

    public void deleteData(long _id) {
        repo.deleteBy_id(_id);
    }

    public List<Style> getAllData(){
        return dao.getAllData();

    }

    @Override
    public void deletebyId(long id) {
        dao.deleteStyle(id);
    }
}