package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    void insert(User user);

}
