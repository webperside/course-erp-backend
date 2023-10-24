package com.webperside.courseerpbackend.services.user.settings;

import com.webperside.courseerpbackend.constants.UserConfigConstants;
import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.mybatis.language.Language;
import com.webperside.courseerpbackend.repository.LanguageRepository;
import com.webperside.courseerpbackend.repository.UserConfigRepository;
import com.webperside.courseerpbackend.services.language.LanguageService;
import com.webperside.courseerpbackend.services.userconfig.UserConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserSettingsBusinessServiceImpl implements UserSettingsBusinessService{

    private final LanguageService languageService;
    private final UserConfigService userConfigService;


    @Override
    public void updateUserDefaultLanguage(Long userId, String langId) {

        languageService.findById(Long.valueOf(langId));

        userConfigService.updateUserLanguage(userId,langId);
    }
}

