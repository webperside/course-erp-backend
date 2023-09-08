package com.webperside.courseerpbackend.services.language;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.mybatis.language.Language;
import com.webperside.courseerpbackend.repository.LangugaeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LangugaeRepository langugaeRepository;
    @Override
    public void insert(Language language) {
        langugaeRepository.insert(language);
    }

    @Override
    public List<Language> findAll() {
        return langugaeRepository.findAll();
    }

    @Override
    public Language findById(Long id) {
        return langugaeRepository.findById(id).orElseThrow(()-> BaseException.notFound(Language.class.getSimpleName(),"language", String.valueOf(id)));
    }

    @Override
    public void update(Language language) {
        langugaeRepository.update(language);

    }
}
