package com.example.borrow.dto;

import com.example.entity.book.Book;
import com.example.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BorrowDetail {
    private User user;
    private List<Book> bookList;
}
