package com.webperside.courseerpbackend.services.language;

import com.webperside.courseerpbackend.models.mybatis.language.Language;

import java.util.List;

public interface LanguageService {

    void insert(Language language);
    List<Language> findAll();
    Language findById(Long id);
    void update (Language language);

}
