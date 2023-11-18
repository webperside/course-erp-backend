package com.webperside.courseerpbackend.services.teacher;

import com.webperside.courseerpbackend.models.payload.teacher.TeacherPayload;

public interface TeacherBusinessService {
    void addTeacher(TeacherPayload teacherPayload);

    void addTeacherToGroup(long teacherId, long groupId);
}
