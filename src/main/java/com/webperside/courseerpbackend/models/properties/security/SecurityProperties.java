package com.webperside.courseerpbackend.models.properties.security;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties("security")
@Configuration
public class SecurityProperties {

    SecurityJwtData jwt;

}