package com.webperside.courseerpbackend.models.mappers;

import com.webperside.courseerpbackend.models.mybatis.group.Group;
import com.webperside.courseerpbackend.models.payload.group.GroupPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupEntityMapper {

    GroupEntityMapper INSTANCE = Mappers.getMapper(GroupEntityMapper.class);

    Group toEntity (GroupPayload groupPayload);

    @Mapping(source = "id", target="id")
    Group toEntity (GroupPayload groupPayload, Long id);

}
