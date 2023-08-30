package com.example.borrow.feign;

import com.example.borrow.feign.impl.UserCallbackClient;
import com.example.entity.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过服务名称访问
 */
@Service
@FeignClient(value = "userservice/api/v1/user", fallback = UserCallbackClient.class)
public interface UserClient {
    @RequestMapping("/{id}")
    User getUserById(@PathVariable("id") Long id);
}
