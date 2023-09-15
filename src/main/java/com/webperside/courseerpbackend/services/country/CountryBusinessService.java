package com.webperside.courseerpbackend.services.country;

import com.webperside.courseerpbackend.models.payload.country.CountryPayload;

public interface CountryBusinessService {
    void insert(CountryPayload countryPayload);
    void update(long id, CountryPayload countryPayload);
}
