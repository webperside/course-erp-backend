package com.webperside.courseerpbackend.services.appConfigs;

import com.webperside.courseerpbackend.models.mybatis.appConfigs.AppConfig;

import java.util.List;

public interface AppConfigService {

    List<AppConfig> findAll();

    AppConfig findById(Long id);

    void insert(AppConfig appConfig);

    void update(AppConfig appConfig);
}
