package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
public interface UserRepository {

    void insert(User user);

    Optional<User> findByEmail(@Param("email") String email);

    Optional<User> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
