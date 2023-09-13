package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.mybatis.country.Country;
import com.webperside.courseerpbackend.services.country.CountryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/countries")
public class CountryController {

    private final CountryServiceImpl countryService;

    @PostMapping
    public void insert(@RequestBody Country country){
        countryService.insert(country);
    }

}
