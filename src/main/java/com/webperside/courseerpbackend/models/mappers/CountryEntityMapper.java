package com.webperside.courseerpbackend.models.mappers;

import com.webperside.courseerpbackend.models.mybatis.country.Country;
import com.webperside.courseerpbackend.models.payload.country.CountryPayload;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryEntityMapper {
    CountryEntityMapper INSTANCE = Mappers.getMapper(CountryEntityMapper.class);


    Country toEntity(CountryPayload countryPayload);
    Country toEntity(CountryPayload countryPayload, @MappingTarget Country country);
}
