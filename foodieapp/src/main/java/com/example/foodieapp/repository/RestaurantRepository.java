package com.example.foodieapp.repository;



import com.example.foodieapp.entity.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    List<Restaurant> findByLocation(String location);
    List<Restaurant> findByNameContaining(String name);
    List<Restaurant> findByDishes_Name(String dishName);
}
