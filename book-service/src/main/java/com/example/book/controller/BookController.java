package com.example.book.controller;

import com.example.book.service.BookService;
import com.example.entity.book.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(
            @Validated
            @Min(value = 1, message = "{book.minid}")
            @NotNull(message = "{book.notnull}")
            @PathVariable("id") Long id,
            HttpServletRequest request) {
        log.info("Book service invoked!");
        log.info("header={}", request.getHeader("Test"));
        return bookService.getUserById(id);
    }
}
