package com.webperside.courseerpbackend.services.teacher;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.exception.ExceptionBuilder;
import com.webperside.courseerpbackend.models.mybatis.teacher.Teacher;
import com.webperside.courseerpbackend.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;
    
    @Override
    public void insert(Teacher teacher) {
        teacherRepository.insert(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherRepository.update(teacher);
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElseThrow(
                () -> ExceptionBuilder.notFound(Teacher.class.getSimpleName(), "teacher", String.valueOf(id))
        );
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
