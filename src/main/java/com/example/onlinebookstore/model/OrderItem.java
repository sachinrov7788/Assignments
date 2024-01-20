package com.example.onlinebookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document("orderitems")
@AllArgsConstructor
@Data
public class OrderItem {

    private String orderItemId;
    private String bookId;
    private int quantity;
    private int itemPrice;
}
