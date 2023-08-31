package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.country.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CountryRepository {
    void insert(Country country);

    Optional<Country> findById(@Param("id") long id);

    List<Country> findAll();

    void update(@RequestBody Country country);
}
