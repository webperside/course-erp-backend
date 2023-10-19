package com.webperside.courseerpbackend.models.mappers;

import com.webperside.courseerpbackend.models.mybatis.appconfig.AppConfig;
import com.webperside.courseerpbackend.models.response.appconfig.AppConfigResponse;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface AppConfigEntityMapper {

    AppConfigEntityMapper INSTANCE = Mappers.getMapper(AppConfigEntityMapper.class);

    AppConfigResponse fromEntityToPayload (AppConfig appConfig);

    List<AppConfigResponse> fromEntityToPayload (List<AppConfig> appConfigs);

}
