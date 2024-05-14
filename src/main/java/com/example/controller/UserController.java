package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping
    public String hello() {
    	return "hello";
    }
    
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUserProfile(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUserProfile(id, user);
    }

    @PatchMapping("/{id}/password")
    public void updateUserPassword(@PathVariable Long id, @RequestBody String newPassword) {
        userService.updateUserPassword(id, newPassword);
    }
}

