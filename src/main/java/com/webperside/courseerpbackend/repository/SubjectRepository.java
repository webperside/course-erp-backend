package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.subject.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SubjectRepository {

    List<Subject> findAll();
    Optional<Subject> findById(@Param("id") Long id);
    void insert(Subject subject);
    void update (@RequestBody Subject subject);
}
