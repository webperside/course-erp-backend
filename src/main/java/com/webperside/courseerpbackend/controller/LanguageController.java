package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.mybatis.language.Language;
import com.webperside.courseerpbackend.models.payload.language.LanguagePayLoad;
import com.webperside.courseerpbackend.services.language.LanguageBusinessService;
import com.webperside.courseerpbackend.services.language.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageBusinessService languageBusinessService;

    @PostMapping("/languages")
    public BaseResponse<Void> insert(@RequestBody LanguagePayLoad languagePayLoad){
        languageBusinessService.insertLanguage(languagePayLoad);
        return BaseResponse.success();
    }
    @PutMapping("/languages/{id}")
    public BaseResponse<Void> update(@PathVariable("id") Long id, @RequestBody LanguagePayLoad languagePayLoad){
        languageBusinessService.updateLanguage(languagePayLoad);
        return BaseResponse.success();
    }
}
