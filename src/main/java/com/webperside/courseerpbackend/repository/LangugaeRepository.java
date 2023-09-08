package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.language.Language;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LangugaeRepository {
    void insert(Language language);
    List<Language> findAll();
    Optional<Language> findById(@Param("id") Long id);
    void update(Language language);
}
