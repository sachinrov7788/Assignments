package com.example.Springboot.trustrace.dao;

import com.example.Springboot.trustrace.model.Style;

import java.util.List;

public interface DaoInterface {

    List<Style> getAllData();
    void supplierNameUpdate(String oldName,String newName);
    void supplierNameUpdateInstyle(String oldName , String newName);
    void facilityNameUpdate(String oldName, String newName);
    void facilityNameUpdateInstyle(String oldName, String newName);
    void deleteStyle(long id);
}
