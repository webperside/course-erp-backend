package com.webperside.courseerpbackend.services.appconfig;

import com.webperside.courseerpbackend.models.mybatis.appconfig.AppConfig;
import com.webperside.courseerpbackend.models.payload.appconfig.AppConfigPayload;

import java.util.List;

public interface AppConfigService {

    List<AppConfigPayload> findAll();

    AppConfigPayload findById(Long id);

    void insert(AppConfig appConfig);

    void update(AppConfig appConfig);
}
