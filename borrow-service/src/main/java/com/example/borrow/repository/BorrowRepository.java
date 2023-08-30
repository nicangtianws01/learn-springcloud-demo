package com.example.borrow.repository;

import com.example.entity.borrow.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BorrowRepository {
    @Select("select * from book_borrow_info where uid = #{uid}")
    List<Borrow> getBorrowListByUserId(@Param("uid") Long uid);

    @Select("select * from book_borrow_info where bid = #{bid}")
    List<Borrow> getBorrowListByBookId(@Param("bid") Long bid);

    @Select("select * from book_borrow_info where uid = #{uid}  and bid = #{bid}")
    Borrow getBorrowByBookIdAndUserId(@Param("uid") Long uid, @Param("bid") Long bid);
}
