package com.example.onlinebookstore.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.onlinebookstore.model.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

    Inventory findByUsername(String username);

    String deleteByUsername(String username);

    Boolean existsByUsername(String username);
}
