package com.example.onlinebookstore.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("publishers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Publisher {
    private String publisherId;
    private String publishername;
}
