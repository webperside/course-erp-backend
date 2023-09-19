package com.webperside.courseerpbackend.services.appConfigs;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.mybatis.appConfigs.AppConfigs;
import com.webperside.courseerpbackend.repository.AppConfigsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppConfigsServiceImpl implements AppConfigsService {

    private final AppConfigsRepository appConfigsRepository;

    @Override
    public List<AppConfigs> findAll() {

        return appConfigsRepository.findAll();

    }

    @Override
    public AppConfigs findById(Long id) {

        return appConfigsRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(AppConfigs.class.getSimpleName(), "app_configs", String.valueOf(id))
        );

    }

    @Override
    public void insert(AppConfigs appConfigs) {

        appConfigsRepository.insert(appConfigs);

    }

    @Override
    public void update(AppConfigs appConfigs) {

        appConfigsRepository.update(appConfigs);

    }
}
