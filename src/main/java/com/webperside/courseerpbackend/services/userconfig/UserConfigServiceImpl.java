package com.webperside.courseerpbackend.services.userconfig;

import com.webperside.courseerpbackend.constants.UserConfigConstants;
import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.mybatis.userconfig.UserConfig;
import com.webperside.courseerpbackend.repository.UserConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserConfigServiceImpl implements UserConfigService {


    private final UserConfigRepository userConfigRepository;

    @Override
    public void insert(UserConfig userConfig) {
        userConfigRepository.insert(userConfig);
    }

    @Override
    public UserConfig findByIdAndUserId(String id, Long userId) {
        return userConfigRepository.findByIdAndUserId(id, userId).orElseThrow(
                () -> BaseException.notFound(UserConfig.class.getSimpleName(),"user_config",String.valueOf(id))
        );
    }

    @Override
    public List<UserConfig> findAll() {
        return userConfigRepository.findAll();
    }

    @Override
    public void update(UserConfig userConfig) {
        userConfigRepository.update(userConfig);
    }


    @Override
    public void updateUserLanguage(Long userId, String langId) {

        userConfigRepository.updateConfig(UserConfigConstants.DEFAULT_LANGUAGE, langId, userId);


    }


}
