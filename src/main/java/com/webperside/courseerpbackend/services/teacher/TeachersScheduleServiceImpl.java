package com.webperside.courseerpbackend.services.teacher;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.mybatis.teacher.TeachersSchedule;
import com.webperside.courseerpbackend.repository.TeachersScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeachersScheduleServiceImpl implements TeachersScheduleService {

    private final TeachersScheduleRepository teachersScheduleRepository;


    @Override
    public TeachersSchedule findById(Long id) {
        return teachersScheduleRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(
                        TeachersSchedule.class.getSimpleName(),
                        "id",
                        id
                )
        );
    }

    @Override
    public List<TeachersSchedule> findAll() {
        return teachersScheduleRepository.findAll();
    }

    @Transactional
    @Override
    public void insert(TeachersSchedule teachersSchedule) {
        teachersScheduleRepository.insert(teachersSchedule);
    }

    @Transactional
    @Override
    public void update(TeachersSchedule teachersSchedule) {
        teachersScheduleRepository.update(teachersSchedule);
    }
}
