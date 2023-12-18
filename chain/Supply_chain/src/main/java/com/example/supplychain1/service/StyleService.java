package com.example.supplychain1.service;

import com.example.supplychain1.model.Style;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface StyleService {
    void save(Style theStyle);
    void update(Style theStyle);
    void delete(long id);
    List<Style> getAllData();
    Optional<Style> getById(long id);
}
