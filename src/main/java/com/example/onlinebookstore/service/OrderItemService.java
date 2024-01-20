package com.example.onlinebookstore.service;

import com.example.onlinebookstore.model.OrderItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> getAllOrderItems();

    OrderItem getOrderItemById(String orderItemId);

    OrderItem createOrderItem(OrderItem newOrderItem);

    OrderItem updateOrderItem(String orderItemId, OrderItem updatedOrderItem);

    String deleteOrderItem(String orderItemId);
}
