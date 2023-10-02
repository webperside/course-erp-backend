package com.webperside.courseerpbackend.services.student;

import com.webperside.courseerpbackend.models.mybatis.student.Student;
import com.webperside.courseerpbackend.models.payload.student.StudentPayload;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    void insert(Student student);

    void update(Student student);

    Student findById(Long id);

    List<Student> findAll();

    void addStudentToGroup(@Param("id") long id, @Param("groupId") long groupId);
    boolean checkByStudentId(long id);

}
