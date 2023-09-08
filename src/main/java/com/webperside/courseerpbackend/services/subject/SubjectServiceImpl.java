package com.webperside.courseerpbackend.services.subject;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.mybatis.subject.Subject;
import com.webperside.courseerpbackend.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService{

    private final SubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id).orElseThrow(
                ()-> BaseException.notFound(Subject.class.getSimpleName(),"subject",String.valueOf(id)));
    }

    @Override
    public void insert(Subject subject) {
        subjectRepository.insert(subject);
    }

    @Override
    public void update(Subject subject) {
        subjectRepository.update(subject);
    }
}


