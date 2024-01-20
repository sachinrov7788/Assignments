package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.model.Inventory;
import com.example.onlinebookstore.repository.InventoryRepository;
import com.example.onlinebookstore.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> getAllInventories() {
        try {
            List<Inventory> inventory = inventoryRepository.findAll();
            return inventory;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Inventory getInventoryByUsername(String username) {
        try {
            Inventory optionalInventory = inventoryRepository.findByUsername(username);
            return optionalInventory;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Inventory createInventory(Inventory newInventory) {
        try {
            Inventory existingInventory = inventoryRepository.findByUsername(newInventory.getUsername());

            if(existingInventory==null){
                inventoryRepository.save(newInventory);
                return newInventory;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Inventory updateInventory(String username, Inventory updatedInventory) {
        try {
            Inventory existingInventory = inventoryRepository.findByUsername(username);

            if(existingInventory!=null){
                updatedInventory.setUsername(existingInventory.getUsername());
                inventoryRepository.save(updatedInventory);
                return updatedInventory;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteInventory(String username) {
        try{
            Boolean existingInventory = inventoryRepository.existsByUsername(username);

            if(existingInventory){
                inventoryRepository.deleteByUsername(username);
                return "Deleted Successfully";
            }
            else{
                return "Username not found give valid username";
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }
}
