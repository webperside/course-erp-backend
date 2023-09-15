package com.webperside.courseerpbackend.services.country;

import com.webperside.courseerpbackend.models.mappers.CountryEntityMapper;
import com.webperside.courseerpbackend.models.mybatis.country.Country;
import com.webperside.courseerpbackend.models.payload.country.CountryPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryBusinessServiceImpl implements CountryBusinessService {

    private final CountryService countryService;
    private static final CountryEntityMapper countryEntityMapper = CountryEntityMapper.INSTANCE;

    @Override
    public void insert(CountryPayload countryPayload) {
        Country country = countryEntityMapper.toEntity(countryPayload);
        countryService.insert(country);
    }

    @Override
    public void update(long id, CountryPayload countryPayload) {
        Country foundedCountry = countryService.findById(id);
        foundedCountry = CountryEntityMapper.INSTANCE.toEntity(countryPayload,foundedCountry);

        countryService.update(foundedCountry);
    }
}
