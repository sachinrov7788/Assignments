package com.example.onlinebookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinebookstore.model.User;
import com.example.onlinebookstore.repository.UserRepository;
import com.example.onlinebookstore.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        try {
            List<User> users = userRepository.findAll();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public User getUserByName(String userName) {
        try {
            User optionalUser = userRepository.findByUsername(userName);
            return optionalUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User createUser(User newUser) {
        try {
            User existingUser = userRepository.findByUsername(newUser.getUsername());

            if(existingUser==null){
                userRepository.save(newUser);
                return newUser; // getUserName()
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
    public User updateUser(String userName, User updatedUser) {
        try {
            User existingUser = userRepository.findByUsername(userName);

            if(existingUser!=null){
                updatedUser.setUsername(existingUser.getUsername());
                
                userRepository.save(updatedUser);
                return updatedUser;
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
    public String deleteUser(String username) {
        try {
            Boolean existingUser = userRepository.existsByUsername(username);

            if(existingUser){
                userRepository.deleteByUsername(username);
                return "Deleted Successfully";
            }
            else{
                return "UserId not found give valid userId";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
