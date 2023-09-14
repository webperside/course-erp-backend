package com.webperside.courseerpbackend.models.mappers;

import com.webperside.courseerpbackend.models.payload.student.StudentPayload;
import com.webperside.courseerpbackend.models.mybatis.student.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentEntityMapper {
    StudentEntityMapper INSTANCE = Mappers.getMapper(StudentEntityMapper.class);

    @Mapping(target = "userId", source = "userId")
    Student studentDtoToStudent(Long userId);
}
