package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.userconfig.UserConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserConfigRepository {
    void insert(UserConfig userConfig);

    Optional<UserConfig> findByIdAndUserId(@Param("id") String id, @Param("userId") Long userId);

    List<UserConfig> findAll();

    void update(UserConfig userConfig);

    void updateUserLanguage(@Param("id") String id, @Param("value") String value, @Param("userId") Long userId);

    boolean findByLangId( @Param("value") String value);

}
