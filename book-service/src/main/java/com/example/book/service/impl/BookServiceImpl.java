package com.example.book.service.impl;

import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import com.example.entity.book.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book getUserById(Long bid) {
        return bookRepository.getUserById(bid);
    }
}
