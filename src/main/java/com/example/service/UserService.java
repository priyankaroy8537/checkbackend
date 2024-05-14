package com.example.service;

import com.example.model.User;

public interface UserService {
    User getUserById(Long id);
    void deleteUserById(Long id);
    User updateUserProfile(Long id, User user);
    void updateUserPassword(Long id, String newPassword);
    User createUser(User user);
}

