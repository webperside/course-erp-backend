package com.webperside.courseerpbackend.services.student;

import com.webperside.courseerpbackend.models.payload.student.StudentPayload;
import org.apache.ibatis.annotations.Param;

public interface StudentBusinessService {

    void addStudent(StudentPayload studentPayload);

    void addStudentToGroup(long studentId, long groupId);
}
