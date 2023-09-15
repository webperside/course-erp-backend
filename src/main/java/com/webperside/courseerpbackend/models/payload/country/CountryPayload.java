package com.webperside.courseerpbackend.models.payload.country;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryPayload {
    String name;
}
