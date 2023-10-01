package com.webperside.courseerpbackend.services.user;

import com.webperside.courseerpbackend.models.mybatis.user.User;

public interface UserService {

    void insert(User user);

    void update(User user);

    User getByEmail(String email);

    User getById(Long id);

    boolean checkByEmail(String email);

    boolean checkByPhoneNumber(String phoneNumber);
}
