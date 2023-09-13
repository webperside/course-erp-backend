package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.mybatis.country.Country;
import com.webperside.courseerpbackend.services.country.CountryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/countries")
public class CountryController {

    private final CountryServiceImpl countryService;

    @PostMapping
    public void insert(@RequestBody Country country){
        countryService.insert(country);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Country country){
        country.setId(id);
        countryService.update(country);
    }

}
