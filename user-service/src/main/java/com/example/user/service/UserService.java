package com.example.user.service;

import com.example.entity.user.User;

public interface UserService {
    /**
     * Get user info by user id
     * @return
     */
    User getUserById(Long uid);
}
