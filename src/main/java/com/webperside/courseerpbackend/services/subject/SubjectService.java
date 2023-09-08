package com.webperside.courseerpbackend.services.subject;

import com.webperside.courseerpbackend.models.mybatis.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SubjectService {

    List<Subject> findAll();
    Subject findById(Long id);
    void  insert(Subject subject);
    void update (Subject subject);
}
