package com.example.book.repository;

import com.example.entity.book.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookRepository {
    @Select("select *from book_info where bid = #{bid}")
    Book getUserById(@Param("bid") Long bid);
}
