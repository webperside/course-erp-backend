package com.webperside.courseerpbackend.services.country;

import com.webperside.courseerpbackend.models.mybatis.country.Country;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CountryService {

    void insert(Country country);
    Country findById(long id);

    List<Country> findAll();

    void update(@RequestBody Country country);
}
