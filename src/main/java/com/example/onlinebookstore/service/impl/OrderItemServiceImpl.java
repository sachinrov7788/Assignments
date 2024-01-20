package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.model.OrderItem;
import com.example.onlinebookstore.repository.OrderItemRepository;
import com.example.onlinebookstore.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        try {
            List<OrderItem> orderItems = orderItemRepository.findAll();
            return orderItems;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public OrderItem getOrderItemById(String orderItemId) {
        try {
            OrderItem optionalOrderItem = orderItemRepository.findById(orderItemId).orElse(null);
            return optionalOrderItem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public OrderItem createOrderItem(OrderItem newOrderItem) {
        try{
            OrderItem existingOrderItem = orderItemRepository.findByOrderItemId(newOrderItem.getOrderItemId());

            if(existingOrderItem==null){
                orderItemRepository.save(newOrderItem);
                return newOrderItem;
            }
            else{
                return null;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public OrderItem updateOrderItem(String orderItemId, OrderItem updatedOrderItem) {
        try {
            OrderItem existingOrderItem = orderItemRepository.findByOrderItemId(orderItemId);

            if(existingOrderItem!=null){
                updatedOrderItem.setOrderItemId(existingOrderItem.getOrderItemId());
                orderItemRepository.save(updatedOrderItem);
                return updatedOrderItem;
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
    public String deleteOrderItem(String orderItemId) {
        try {
            Boolean existingOrderItem = orderItemRepository.existsByOrderItemId(orderItemId);
            
            if(existingOrderItem){
                orderItemRepository.deleteByOrderItemId(orderItemId);
                return "Deleted Successfully";
            }

            else{
                return "OrderItemId not found give valid orderitemid";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
