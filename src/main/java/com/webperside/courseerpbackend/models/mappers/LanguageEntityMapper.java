package com.webperside.courseerpbackend.models.mappers;

import com.webperside.courseerpbackend.models.mybatis.language.Language;
import com.webperside.courseerpbackend.models.payload.language.LanguagePayLoad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LanguageEntityMapper {

    LanguageEntityMapper INSTANCE = Mappers.getMapper(LanguageEntityMapper.class);

    @Mapping(target = "name", source="name")
    Language fromLanguagePayLoad(LanguagePayLoad languagePayLoad,String name);
}
