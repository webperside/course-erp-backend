package com.webperside.courseerpbackend.models.mappers;

import com.webperside.courseerpbackend.models.dto.SubjectRequestDto;
import com.webperside.courseerpbackend.models.mybatis.subject.Subject;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.payload.auth.SignUpPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubjectEntityMapper {
    SubjectEntityMapper INSTANCE = Mappers.getMapper(SubjectEntityMapper.class);

    @Mapping(target = "courseId", source = "courseId")
    Subject fromSubjectRequestDto(SubjectRequestDto subjectRequestDto,Long courseId);
}
