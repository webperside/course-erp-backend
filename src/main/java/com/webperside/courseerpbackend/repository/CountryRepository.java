package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.country.Country;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CountryRepository {
    void insert(Country country);
}
