package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.dto.SubjectRequestDto;
import com.webperside.courseerpbackend.models.mappers.SubjectEntityMapper;
import com.webperside.courseerpbackend.models.mybatis.subject.Subject;
import com.webperside.courseerpbackend.services.language.LanguageService;
import com.webperside.courseerpbackend.services.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;
    private final LanguageService languageService;

    @PostMapping("/subjects")
    public BaseResponse<?> addSubject(@RequestBody SubjectRequescd coutDto subjectRequestDto){
        Long languageId = subjectRequestDto.getLanguageId();
        try{
            languageService.findById(languageId);
            Subject subject = SubjectEntityMapper.INSTANCE.fromSubjectRequestDto(subjectRequestDto,1L);
            // TODO
            subjectService.insert(subject);
            return BaseResponse.success();
        }catch (BaseException baseException){
            return BaseResponse.error(baseException);
        }
    }
}
