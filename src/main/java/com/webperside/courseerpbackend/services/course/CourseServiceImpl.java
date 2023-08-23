package com.webperside.courseerpbackend.services.course;

import com.webperside.courseerpbackend.models.mybatis.course.Course;
import com.webperside.courseerpbackend.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public void insert(Course course) {
        courseRepository.insert(course);
    }
}
