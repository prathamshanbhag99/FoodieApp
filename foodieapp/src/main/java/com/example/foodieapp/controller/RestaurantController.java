package com.example.foodieapp.controller;


import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public Restaurant registerRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.registerRestaurant(restaurant);
    }

    @GetMapping
    public List<Restaurant> findRestaurants(@RequestParam(required = false) String location,
                                            @RequestParam(required = false) String name,
                                            @RequestParam(required = false) String dishName) {
        return restaurantService.findRestaurants(location, name, dishName);
    }
}
