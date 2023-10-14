package com.webperside.courseerpbackend.services.teacher;

import com.webperside.courseerpbackend.models.mybatis.teacher.TeachersSchedule;

import java.util.Collection;
import java.util.Optional;

public interface TeachersScheduleService {
    void insert(TeachersSchedule teachersSchedule);
    TeachersSchedule findById(Long id);
    Collection<TeachersSchedule> findAll();
    void update(TeachersSchedule teachersSchedule);
}
