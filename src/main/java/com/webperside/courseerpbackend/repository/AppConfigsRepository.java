package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.appConfigs.AppConfigs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AppConfigsRepository {
    void insert(AppConfigs appConfigs);

    Optional<AppConfigs> findById(@Param("id") long id);

    List<AppConfigs> findAll();

    void update(AppConfigs appConfigs);
}
