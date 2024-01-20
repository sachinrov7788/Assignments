package com.example.onlinebookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String username;
    private String password;
    private String email;
    private String role;
    private String contactInformation;
    private String storeName;
    
}
