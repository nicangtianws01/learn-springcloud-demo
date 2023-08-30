package com.example.borrow.feign.impl;

import com.example.borrow.feign.UserClient;
import com.example.entity.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserCallbackClient implements UserClient {
    @Override
    public User getUserById(Long id) {
        return new User(1L, "test", 1, "M");
    }
}
