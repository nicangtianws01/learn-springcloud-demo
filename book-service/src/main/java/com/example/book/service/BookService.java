package com.example.book.service;

import com.example.entity.book.Book;

public interface BookService {
    /**
     * Get book info by user id
     * @param bid
     * @return
     */
    Book getUserById(Long bid);
}
