package com.example.borrow.feign;

import com.example.borrow.feign.impl.BookCallbackClient;
import com.example.entity.book.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过服务名称访问
 */
@Service
@FeignClient(value = "bookservice/api/v1/book", fallback = BookCallbackClient.class)
public interface BookClient {
    @RequestMapping("/{id}")
    Book getBookById(@PathVariable("id") Long id);
}
