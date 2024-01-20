package com.example.onlinebookstore.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onlinebookstore.model.Author;
import com.example.onlinebookstore.model.OrderItem;
import com.example.onlinebookstore.service.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        return new ResponseEntity<List<OrderItem>>(orderItems, HttpStatus.OK);
    }

    @GetMapping("/{orderItemId}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable String orderItemId) {
        OrderItem orderItems = orderItemService.getOrderItemById(orderItemId);
        return new ResponseEntity<OrderItem>(orderItems, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem newOrderItem) {
        OrderItem orderItems = orderItemService.createOrderItem(newOrderItem);
        return new ResponseEntity<OrderItem>(orderItems, HttpStatus.CREATED);
    }

    @PutMapping("/{orderItemId}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable String orderItemId, @RequestBody OrderItem updatedOrderItem) {
        OrderItem orderItems = orderItemService.updateOrderItem(orderItemId, updatedOrderItem);
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }

    @DeleteMapping("/{orderItemId}")
    public ResponseEntity<String> deleteOrderItem(@PathVariable String orderItemId) {
        String orderItems = orderItemService.deleteOrderItem(orderItemId);
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }
}
