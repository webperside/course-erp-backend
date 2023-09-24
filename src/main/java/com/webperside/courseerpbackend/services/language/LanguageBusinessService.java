package com.webperside.courseerpbackend.services.language;

import com.webperside.courseerpbackend.models.payload.language.LanguagePayLoad;

public interface LanguageBusinessService {

    void insertLanguage(LanguagePayLoad languagePayLoad);
    void updateLanguage(LanguagePayLoad languagePayLoad);
}
