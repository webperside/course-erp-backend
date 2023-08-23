package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.course.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseRepository {

    void insert(Course course);

}
