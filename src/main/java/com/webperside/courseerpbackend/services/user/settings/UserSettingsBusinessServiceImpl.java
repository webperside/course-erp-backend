package com.webperside.courseerpbackend.services.user.settings;

import com.webperside.courseerpbackend.constants.UserConfigConstants;
import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.mybatis.userconfig.UserConfig;
import com.webperside.courseerpbackend.repository.UserConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserSettingsBusinessServiceImpl implements UserSettingsBusinessService{

    private final UserConfigRepository userConfigRepository;

    @Override
    public void updateUserDefaultLanguage(Long userId, String langId) {


        boolean exists = userConfigRepository.findByLangId(langId);
        if (!exists) {
            throw  BaseException.notFound(UserConfig.class.getSimpleName(),"value",langId);

        }
        userConfigRepository.updateUserLanguage(UserConfigConstants.DEFAULT_LANGUAGE, langId, userId);

    }
}

