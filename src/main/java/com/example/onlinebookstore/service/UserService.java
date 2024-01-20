package com.example.onlinebookstore.service;
import org.springframework.http.ResponseEntity;

import com.example.onlinebookstore.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByName(String userName);

    User createUser(User newUser);

    User updateUser(String userId, User updatedUser);

    String deleteUser(String userId);
}
