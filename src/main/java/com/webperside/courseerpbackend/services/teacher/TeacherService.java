package com.webperside.courseerpbackend.services.teacher;

import com.webperside.courseerpbackend.models.mybatis.student.Student;
import com.webperside.courseerpbackend.models.mybatis.teacher.Teacher;

import java.util.List;

public interface TeacherService {
    void insert(Teacher teacher);

    void update(Teacher teacher);

    Teacher findById(Long id);

    List<Teacher> findAll();

    boolean checkTeacherAlreadyAddedToGroup(long teacherId);
}
