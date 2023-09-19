package com.webperside.courseerpbackend.services.appConfigs;

import com.webperside.courseerpbackend.models.mybatis.appConfigs.AppConfigs;

import java.util.List;

public interface AppConfigsService {

    List<AppConfigs> findAll();

    AppConfigs findById(Long id);

    void insert(AppConfigs appConfigs);

    void update(AppConfigs appConfigs);
}
