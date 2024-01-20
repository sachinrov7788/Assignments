package com.example.onlinebookstore.service;

import org.springframework.http.ResponseEntity;

import com.example.onlinebookstore.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order getOrderById(String orderId);

    Order createOrder(Order newOrder);

    Order updateOrder(String orderId, Order updatedOrder);

    String deleteOrder(String orderId);
}
