package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Create or Update User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Delete User by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Update User by ID
    public User updateUser(Long id, User updatedUser) {
        // Check if user exists
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // Update fields
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            
            return userRepository.save(existingUser);  // Save the updated user
        }
        return null;  // Return null if user is not found
    }

    public Page<User> getUserByPage(int page,int size)
{
   Pageable pageable= PageRequest.of(page,size);
   return userRepository.findAll(pageable);
}

     public List<User>SortByUser()
{
    return userRepository.findAll(Sort.by("name").ascending());
}
}
