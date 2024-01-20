package com.example.onlinebookstore.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document("inventory")
@AllArgsConstructor
@Data
public class Inventory {
    private String username;
    private List<String> bookId;
}
