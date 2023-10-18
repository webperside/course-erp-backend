package com.webperside.courseerpbackend.utils;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Data
@Component
@RequestScope
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestDataStorage {

    String userId;

    String userLanguage;

}
