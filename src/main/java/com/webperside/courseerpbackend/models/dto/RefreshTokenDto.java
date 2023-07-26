package com.webperside.courseerpbackend.models.dto;

import com.webperside.courseerpbackend.models.mybatis.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshTokenDto {

    boolean rememberMe;
    User user;

}
