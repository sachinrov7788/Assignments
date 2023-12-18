package com.example.SupplyChain.SpringBoot_Project1.service;

import com.example.SupplyChain.SpringBoot_Project1.model.Style;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface StyleService {
    void save(Style theStyle);
    void update(Style theStyle);
    void delete(String id);
    List<Style> getAllData();
    Optional<Style> getById(String id);
}
