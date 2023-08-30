package com.example.borrow.feign.impl;

import com.example.borrow.feign.BookClient;
import com.example.entity.book.Book;
import org.springframework.stereotype.Component;

@Component
public class BookCallbackClient implements BookClient {
    @Override
    public Book getBookById(Long id) {
        return new Book(1L, "test", "test book");
    }
}
