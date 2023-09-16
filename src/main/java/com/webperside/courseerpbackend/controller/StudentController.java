package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.payload.student.StudentPayload;
import com.webperside.courseerpbackend.services.student.StudentBusinessService;
import com.webperside.courseerpbackend.services.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentBusinessService studentBusinessService;

    @PostMapping
    public BaseResponse<Void> addStudent(@RequestBody StudentPayload studentPayload) {
        studentBusinessService.addStudent(studentPayload);
        return BaseResponse.success();

    }
}
