package com.webperside.courseerpbackend.services.student;

import com.webperside.courseerpbackend.models.mybatis.student.Student;
import com.webperside.courseerpbackend.models.payload.student.StudentPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    void insert(Student student);

    void update(Student student);

    Student findById(Long id);

    List<Student> findAll();

    void addStudent(StudentPayload studentPayload);

}
