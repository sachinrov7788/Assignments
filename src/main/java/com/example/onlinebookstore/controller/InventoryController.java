package com.example.onlinebookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onlinebookstore.model.Inventory;
import com.example.onlinebookstore.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories() {
        List<Inventory> inventories = inventoryService.getAllInventories();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Inventory> getInventoryByUserName(@PathVariable String username) {
        Inventory inventory = inventoryService.getInventoryByUsername(username);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory newInventory) {
        Inventory inventory = inventoryService.createInventory(newInventory);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }
    
    @PutMapping("/{username}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable String username, @RequestBody Inventory updatedInventory) {
        Inventory inventory = inventoryService.updateInventory(username, updatedInventory);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteInventory(@PathVariable String username) {
        String inventory = inventoryService.deleteInventory(username);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }
}
