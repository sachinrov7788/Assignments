package com.example.onlinebookstore.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document("orders")
@AllArgsConstructor
@Data
public class Order {

    private String orderId;
    private String orderItemId;
    private Date orderDate;
    private String username;
    private String status;
    private double totalAmount;
}
