package com.example.onlinebookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.onlinebookstore.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

    Order findByOrderId(String orderId);

    Boolean existsByOrderId(String orderId);

    String deleteByOrderId(String orderId);
    
}
