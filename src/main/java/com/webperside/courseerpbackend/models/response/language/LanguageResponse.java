package com.webperside.courseerpbackend.models.response.language;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LanguageResponse {

    String name;
    String icon;
    Boolean hasLocalization;
    Boolean isDefault;

}
