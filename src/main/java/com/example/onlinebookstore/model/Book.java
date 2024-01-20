package com.example.onlinebookstore.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("books")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private String bookId;
    private String title;
    private String authorId;
    private String description;
    private String publisherId;
    private int price;
    private int quantity;
}
