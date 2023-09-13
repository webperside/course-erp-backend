package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.mybatis.language.Language;
import com.webperside.courseerpbackend.services.language.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @PostMapping("/languages")
    public void insert(@RequestBody Language language){
        languageService.insert(language);
    }
    @PutMapping("/languages/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Language language){
        language.setId(id);
        languageService.update(language);
    }
}
