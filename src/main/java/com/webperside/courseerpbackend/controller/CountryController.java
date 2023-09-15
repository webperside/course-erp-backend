package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.payload.country.CountryPayload;
import com.webperside.courseerpbackend.services.country.CountryBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/countries")
public class CountryController {

    private final CountryBusinessService countryBusinessService;

    @PostMapping("/country")
    public void insert(@RequestBody CountryPayload countryPayload){
        countryBusinessService.insert(countryPayload);
    }

    @PutMapping("/country/{id}")
    public void update(@PathVariable("id") long id, @RequestBody CountryPayload countryPayload){
        countryBusinessService.update(id, countryPayload);
    }

}
