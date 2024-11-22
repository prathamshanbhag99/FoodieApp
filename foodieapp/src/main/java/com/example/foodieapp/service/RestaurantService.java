package com.example.foodieapp.service;


import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant registerRestaurant(Restaurant restaurant) {
        restaurant.setApproved(false);
        restaurant.setEnabled(true);
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> findRestaurants(String location, String name, String dishName) {
        if (location != null) return restaurantRepository.findByLocation(location);
        if (name != null) return restaurantRepository.findByNameContaining(name);
        if (dishName != null) return restaurantRepository.findByDishes_Name(dishName);
        return restaurantRepository.findAll();
    }
}
