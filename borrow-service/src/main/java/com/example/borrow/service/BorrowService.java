package com.example.borrow.service;

import com.example.borrow.dto.BorrowDetail;

public interface BorrowService {
    /**
     *
     * @param uid
     * @return
     */
    BorrowDetail getBorrowDetailByUserId(Long uid);
}
