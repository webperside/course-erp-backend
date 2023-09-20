package com.webperside.courseerpbackend.services.userconfig;

import com.webperside.courseerpbackend.models.mybatis.userconfig.UserConfig;

import java.util.List;

public interface UserConfigService {

    void insert(UserConfig userConfig);
    UserConfig findByIdAndUserId(String id, Long userId);

    List<UserConfig> findAll();

    void update(UserConfig userConfig);
}
