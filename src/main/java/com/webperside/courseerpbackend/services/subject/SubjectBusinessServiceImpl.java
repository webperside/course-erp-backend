package com.webperside.courseerpbackend.services.subject;

import com.webperside.courseerpbackend.models.mappers.SubjectEntityMapper;
import com.webperside.courseerpbackend.models.payload.subject.SubjectPayload;
import com.webperside.courseerpbackend.services.language.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectBusinessServiceImpl implements SubjectBusinessService {
    private final SubjectService subjectService;
    private final LanguageService languageService;

    @Override
    public void insertSubject(SubjectPayload subjectPayload) {
        languageService.findById(subjectPayload.getLanguageId());
        subjectService.insert(SubjectEntityMapper.INSTANCE.fromSubjectPayload(subjectPayload, 1L));
    }
}
