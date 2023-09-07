package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.student.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentRepository {

    void insert(Student student);

    void update(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();
}
