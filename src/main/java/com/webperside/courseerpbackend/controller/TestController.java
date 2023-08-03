package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public BaseResponse<String> test() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return BaseResponse.success(userDetails.getUsername());
    }

    @GetMapping("/test/no-auth")
    public BaseResponse<String> testNoAuth() {

        userService.getByEmail("sdkjfhsdkjfh");

        return BaseResponse.success("Course ERP - No Auth");
    }

}
