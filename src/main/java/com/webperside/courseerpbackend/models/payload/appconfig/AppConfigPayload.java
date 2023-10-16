package com.webperside.courseerpbackend.models.payload.appconfig;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfigPayload {
    String value;
    String description;
}
