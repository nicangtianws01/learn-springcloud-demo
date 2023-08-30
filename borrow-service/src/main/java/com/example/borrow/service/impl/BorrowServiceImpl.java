package com.example.borrow.service.impl;

import com.example.borrow.dto.BorrowDetail;
import com.example.borrow.feign.BookClient;
import com.example.borrow.feign.UserClient;
import com.example.borrow.repository.BorrowRepository;
import com.example.borrow.service.BorrowService;
import com.example.entity.book.Book;
import com.example.entity.borrow.Borrow;
import com.example.entity.user.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    final BorrowRepository borrowRepository;

    /**
     * 基础远程调用工具
     */
    final RestTemplate restTemplate;

    /**
     * 通过openfeign client替换掉上面的restTemplate
     */
    final UserClient userClient;

    final BookClient bookClient;

    public BorrowServiceImpl(BorrowRepository borrowRepository, RestTemplate restTemplate, UserClient userClient, BookClient bookClient) {
        this.borrowRepository = borrowRepository;
        this.restTemplate = restTemplate;
        this.userClient = userClient;
        this.bookClient = bookClient;
    }

    @Override
    public BorrowDetail getBorrowDetailByUserId(Long uid) {
        List<Borrow> borrowList = borrowRepository.getBorrowListByUserId(uid);

//        ResponseEntity<User> userEntity = restTemplate
//                .getForEntity("http://userservice/api/v1/user/" + uid, User.class);
        User user = userClient.getUserById(uid);

        List<Book> bookList = borrowList.stream().map(borrow -> {
//            ResponseEntity<Book> bookEntity = restTemplate
//                    .getForEntity("http://bookservice/api/v1/book/" + borrow.getBid(), Book.class);
            //            return bookEntity.getBody();
            return bookClient.getBookById(borrow.getBid());
        }).collect(Collectors.toList());

//        User user = userEntity.getBody();
        BorrowDetail detail = new BorrowDetail();
        detail.setUser(user);
        detail.setBookList(bookList);
        return detail;
    }
}
