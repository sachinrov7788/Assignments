package com.example.onlinebookstore.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("authors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
    private String authorId;
    private String authorname;
}
