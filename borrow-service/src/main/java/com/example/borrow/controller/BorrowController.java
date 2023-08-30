package com.example.borrow.controller;

import com.example.borrow.dto.BorrowDetail;
import com.example.borrow.service.BorrowService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RequestMapping("/api/v1/borrow")
@RestController
public class BorrowController {

    final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @HystrixCommand(fallbackMethod = "onError")
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public BorrowDetail getBorrowDetailByUserId(@PathVariable("uid") Long uid){
        return borrowService.getBorrowDetailByUserId(uid);
    }

    public BorrowDetail onError(Long uid){
        return new BorrowDetail(null, Collections.emptyList());
    }
}
