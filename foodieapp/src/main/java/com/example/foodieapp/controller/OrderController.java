package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Order;
import com.example.foodieapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

  
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.getOrdersById(id);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<Order> getOrdersForRestaurant(@PathVariable String restaurantId) {
        return orderService.getOrdersByRestaurantId(restaurantId);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersForUser(@PathVariable String userId) {
        return orderService.getOrdersByUserId(userId);
    }

    
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
