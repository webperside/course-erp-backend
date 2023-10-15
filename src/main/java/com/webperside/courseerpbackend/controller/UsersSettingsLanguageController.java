package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.payload.user.settings.UsersLanguagePayload;
import com.webperside.courseerpbackend.services.user.settings.UserSettingsBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users/settings")
@RequiredArgsConstructor
public class UsersSettingsLanguageController {

   private final UserSettingsBusinessService userSettingsBusinessService;


    @PutMapping("/language")
    public BaseResponse<Void> updateDefaultLanguage(@RequestBody UsersLanguagePayload usersLanguagePayload) {
        // For now, we're using 1L as userId

        userSettingsBusinessService.updateUserDefaultLanguage(1L,usersLanguagePayload.getLangId());

        return BaseResponse.success();
    }

}
