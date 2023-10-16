package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.payload.appconfig.AppConfigPayload;
import com.webperside.courseerpbackend.services.appconfig.AppConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/appconfig")
@RequiredArgsConstructor
public class AppConfigController {

    private final AppConfigService appConfigService;

    @GetMapping("/{id}")
    public BaseResponse<AppConfigPayload> findAppConfigById(@PathVariable("id") long id) {
        return BaseResponse.success(appConfigService.findById(id));
    }

    @GetMapping
    public BaseResponse<List<AppConfigPayload>> getAllAppConfigs() {
        return BaseResponse.success(appConfigService.findAll());
    }
}
