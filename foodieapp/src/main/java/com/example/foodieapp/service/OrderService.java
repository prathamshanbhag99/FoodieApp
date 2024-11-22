package com.example.foodieapp.service;

import com.example.foodieapp.entity.Order;
import com.example.foodieapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByRestaurantId(String restaurantId) {
        return orderRepository.findByRestaurantId(restaurantId);
    }

    public List<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order getOrdersById(String id) {
        return orderRepository.findById(id).orElse(null); 
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
