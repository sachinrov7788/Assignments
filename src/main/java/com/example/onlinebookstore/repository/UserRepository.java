package com.example.onlinebookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.onlinebookstore.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String userName);

    Boolean existsByUsername(String username);

    String deleteByUsername(String username);
}
