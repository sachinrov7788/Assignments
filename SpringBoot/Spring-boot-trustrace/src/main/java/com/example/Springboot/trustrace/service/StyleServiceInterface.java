package com.example.Springboot.trustrace.service;

import com.example.Springboot.trustrace.model.Style;

import java.util.List;
public interface StyleServiceInterface {

    List<Style> getAllStyle();
    Style getById(long _id);
    void addData(Style s);
    void updateData(Style s);
    void deleteData(long _id);
    List<Style> getAllData();
    void deletebyId(long id);
}