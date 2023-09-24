package com.webperside.courseerpbackend.services.language;

import com.webperside.courseerpbackend.models.mappers.LanguageEntityMapper;
import com.webperside.courseerpbackend.models.payload.language.LanguagePayLoad;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageBusinessServiceImpl implements LanguageBusinessService {

    private final LanguageService languageService;
    @Override
    public void insertLanguage(LanguagePayLoad languagePayLoad) {
        languageService.insert(LanguageEntityMapper.INSTANCE.fromLanguagePayLoad(languagePayLoad, languagePayLoad.getName()));
    }

    @Override
    public void updateLanguage(LanguagePayLoad languagePayLoad) {
        languageService.update(LanguageEntityMapper.INSTANCE.fromLanguagePayLoad(languagePayLoad, languagePayLoad.getName()));
    }
}
