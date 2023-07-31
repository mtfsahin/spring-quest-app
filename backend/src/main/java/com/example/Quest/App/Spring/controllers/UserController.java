package com.example.Quest.App.Spring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.example.Quest.App.Spring.entities.User;
import com.example.Quest.App.Spring.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        // Kullanıcıların şifrelerini içermeyen verileri alarak döndürme
        List<User> users = userService.getAllUsers();
        
        return users;
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.saveOneUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUserById(@PathVariable Long userId) {
        return userService.getOneUserById(userId);
    }
    
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
    	return userService.updateOneUser(userId, newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
         userService.deleteById(userId);
    }
}
