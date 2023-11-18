package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.payload.teacher.TeacherPayload;
import com.webperside.courseerpbackend.services.teacher.TeacherBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherBusinessService teacherBusinessService;

    @PostMapping
    public BaseResponse<Void> addTeacher(@RequestBody TeacherPayload teacherPayload){
        teacherBusinessService.addTeacher(teacherPayload);
        return BaseResponse.created();
    }

}
