package com.webperside.courseerpbackend.services.teacher;

import com.webperside.courseerpbackend.models.mybatis.teacher.TeachersSchedule;

import java.util.List;

public interface TeachersScheduleService {
    void insert(TeachersSchedule teachersSchedule);

    TeachersSchedule findById(Long id);

    List<TeachersSchedule> findAll();

    void update(TeachersSchedule teachersSchedule);
}
