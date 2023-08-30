package com.example.user.repository;

import com.example.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRepository{

    @Select("select *from book_user_info where uid = #{uid}")
    User getUserById(@Param("uid") Long uid);
}
