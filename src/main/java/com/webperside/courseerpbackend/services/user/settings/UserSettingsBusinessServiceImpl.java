package com.webperside.courseerpbackend.services.user.settings;

import com.webperside.courseerpbackend.constants.UserConfigConstants;
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
        userConfigRepository.updateUserLanguage(UserConfigConstants.DEFAULT_LANGUAGE, langId, userId);

    }
}
