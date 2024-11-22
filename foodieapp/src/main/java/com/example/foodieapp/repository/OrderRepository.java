package com.example.foodieapp.repository;

import com.example.foodieapp.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByRestaurantId(String restaurantId);
    List<Order> findByUserId(String userId);

    Order getOrdersById(String id);
}
