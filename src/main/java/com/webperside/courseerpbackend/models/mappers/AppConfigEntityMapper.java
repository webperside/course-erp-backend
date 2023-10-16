package com.webperside.courseerpbackend.models.mappers;

import com.webperside.courseerpbackend.models.mybatis.appconfig.AppConfig;
import com.webperside.courseerpbackend.models.payload.appconfig.AppConfigPayload;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface AppConfigEntityMapper {

    AppConfigEntityMapper INSTANCE = Mappers.getMapper(AppConfigEntityMapper.class);

    AppConfigPayload fromEntityToPayload (AppConfig appConfig);

    List<AppConfigPayload> fromEntityToPayload (List<AppConfig> appConfigs);

}
