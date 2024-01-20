package com.example.onlinebookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.onlinebookstore.model.Author;
import com.example.onlinebookstore.model.Order;
import com.example.onlinebookstore.repository.OrderRepository;
import com.example.onlinebookstore.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        try {
            List<Order> orders = orderRepository.findAll();
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Order getOrderById(String orderId) {
        try {
            Order optionalOrder = orderRepository.findById(orderId).orElse(null);
            return optionalOrder;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
    }

    @Override
    public Order createOrder(Order newOrder) {
        try {
            Order existingOrder;
            existingOrder = orderRepository.findByOrderId(newOrder.getOrderId());
            
            if(existingOrder==null){
                orderRepository.save(newOrder);
                return newOrder;
            }
            
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Order updateOrder(String orderId, Order updatedOrder) {
        
        try {
            Order existingOrder = orderRepository.findByOrderId(orderId);
            
            if(existingOrder!=null){
                updatedOrder.setOrderId(existingOrder.getOrderId());
                orderRepository.save(updatedOrder);
                return updatedOrder;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteOrder(String orderId) {
        try {
            Boolean existingOrder = orderRepository.existsByOrderId(orderId);
            
            if(existingOrder){
                orderRepository.deleteByOrderId(orderId);
                return "Deleted Successfully";
            }

            else{
                return "OrderId not found give valid orderId";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
