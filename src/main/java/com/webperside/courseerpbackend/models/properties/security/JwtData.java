package com.webperside.courseerpbackend.models.properties.security;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtData {

    String publicKey;
    String privateKey;
    Integer accessTokenValidityTime;
    Integer refreshTokenValidityTime;

    public Long getRefreshTokenValidityTime(boolean rememberMe) {
        return refreshTokenValidityTime * (rememberMe ? 30L : 1L);
    }

}