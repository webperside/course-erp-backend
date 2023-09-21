package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.mappers.CountryEntityMapper;
import com.webperside.courseerpbackend.models.mybatis.country.Country;
import com.webperside.courseerpbackend.models.payload.country.CountryPayload;
import com.webperside.courseerpbackend.services.country.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/countries")
public class CountryController {

    private final CountryService countryService;
    private static final CountryEntityMapper countryEntityMapper = CountryEntityMapper.INSTANCE;

    @PostMapping("/country")
    public BaseResponse<Void> insert(@RequestBody CountryPayload countryPayload){
        Country country = countryEntityMapper.toEntity(countryPayload);
        countryService.insert(country);
        return BaseResponse.success();
    }

    @PutMapping("/country/{id}")
    public BaseResponse<Void> update(@PathVariable("id") long id, @RequestBody CountryPayload countryPayload){
        countryPayload.setId(id);
        Country country = countryEntityMapper.toEntity(countryPayload, new Country());
        countryService.update(country);
        return BaseResponse.success();
    }

}
