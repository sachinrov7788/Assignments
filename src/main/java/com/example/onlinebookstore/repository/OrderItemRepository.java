package com.example.onlinebookstore.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.onlinebookstore.model.OrderItem;

public interface OrderItemRepository extends MongoRepository<OrderItem, String>{

    OrderItem findByOrderItemId(String orderItemId);

    String deleteByOrderItemId(String orderItemId);

    Boolean existsByOrderItemId(String orderItemId);
    
}
