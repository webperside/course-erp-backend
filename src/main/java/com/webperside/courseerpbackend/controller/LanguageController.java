package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.mappers.LanguageEntityMapper;
import com.webperside.courseerpbackend.models.mybatis.language.Language;
import com.webperside.courseerpbackend.models.payload.language.LanguagePayLoad;
import com.webperside.courseerpbackend.services.language.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;


    @PostMapping
    public BaseResponse<Void> insert(@RequestBody LanguagePayLoad languagePayLoad){
        languageService.insert(LanguageEntityMapper.INSTANCE.toEntity(languagePayLoad));
        return BaseResponse.success();
    }
    @PutMapping("/{id}")
    public BaseResponse<Void> update(@PathVariable("id") long id, @RequestBody LanguagePayLoad languagePayLoad){
        languageService.update(LanguageEntityMapper.INSTANCE.toEntity(languagePayLoad, id));
        return BaseResponse.success();
    }
}
