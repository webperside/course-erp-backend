package com.webperside.courseerpbackend.services.language;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.exception.ExceptionBuilder;
import com.webperside.courseerpbackend.models.mybatis.language.Language;
import com.webperside.courseerpbackend.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    public void insert(Language language) {
        languageRepository.insert(language);
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language findById(Long id) {
        return languageRepository.findById(id).orElseThrow(() -> ExceptionBuilder.notFound(Language.class.getSimpleName(), "language", String.valueOf(id)));
    }

    @Override
    public void update(Language language) {
        languageRepository.update(language);

    }

    @Override
    public Language getDefaultLanguage() {
        return languageRepository.getDefaultLanguage().orElseThrow(
                ExceptionBuilder::unexpected
        );
    }

    @Override
    public List<Language> getAllLanguagesIsLocalize() {
        return languageRepository.getAllLanguagesIsLocalize();
    }

}
