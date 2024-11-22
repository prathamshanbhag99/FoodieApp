package com.example.foodieapp.service;

import com.example.foodieapp.entity.User;
import com.example.foodieapp.exception.ResourceNotFoundException;
import com.example.foodieapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        
        return userRepository.save(user);
    }

    
    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }

    
    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with email: " + email);
        }
        return user;
    }

  
    public User updateUser(String id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        if (updatedUser.getPassword() != null) {
            existingUser.setPassword(updatedUser.getPassword()); // Set the plain text password
        }
        return userRepository.save(existingUser);
    }

 
    public void deleteUser(String id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
