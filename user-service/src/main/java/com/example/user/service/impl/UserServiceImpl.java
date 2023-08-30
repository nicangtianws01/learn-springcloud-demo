package com.example.user.service.impl;

import com.example.entity.user.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }
}
