package com.webperside.courseerpbackend.services.appconfig;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.mappers.AppConfigEntityMapper;
import com.webperside.courseerpbackend.models.mybatis.appconfig.AppConfig;
import com.webperside.courseerpbackend.models.payload.appconfig.AppConfigPayload;
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
    public List<AppConfigPayload> findAll() {

        return AppConfigEntityMapper.INSTANCE.fromEntityToPayload(appConfigRepository.findAll());

    }

    @Override
    public AppConfigPayload findById(Long id) {

        return AppConfigEntityMapper.INSTANCE.fromEntityToPayload(appConfigRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(AppConfig.class.getSimpleName(), "app_configs", String.valueOf(id))
        ));

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