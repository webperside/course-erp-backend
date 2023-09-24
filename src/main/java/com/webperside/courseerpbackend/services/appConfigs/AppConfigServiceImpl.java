package com.webperside.courseerpbackend.services.appConfigs;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.mybatis.appConfigs.AppConfig;
import com.webperside.courseerpbackend.repository.AppConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppConfigServiceImpl implements AppConfigService {

    private final AppConfigRepository appConfigRepository;

    @Override
    public List<AppConfig> findAll() {

        return appConfigRepository.findAll();

    }

    @Override
    public AppConfig findById(Long id) {

        return appConfigRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(AppConfig.class.getSimpleName(), "app_configs", String.valueOf(id))
        );

    }

    @Override
    public void insert(AppConfig appConfig) {

        appConfigRepository.insert(appConfig);

    }

    @Override
    public void update(AppConfig appConfig) {

        appConfigRepository.update(appConfig);

    }
}
