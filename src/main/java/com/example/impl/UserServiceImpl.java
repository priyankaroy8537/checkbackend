package com.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUserProfile(Long id, User user) {
        User existingUser = getUserById(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setMobile(user.getMobile());
        return userRepository.save(existingUser);
    }

    @Override
    public void updateUserPassword(Long id, String newPassword) {
        User existingUser = getUserById(id);
        existingUser.setPassword(newPassword);
        userRepository.save(existingUser);
    }
}

