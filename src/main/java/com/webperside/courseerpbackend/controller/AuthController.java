package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.dto.RefreshTokenDto;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.payload.auth.LoginPayload;
import com.webperside.courseerpbackend.models.response.auth.LoginResponse;
import com.webperside.courseerpbackend.services.security.AccessTokenManager;
import com.webperside.courseerpbackend.services.security.RefreshTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    // Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjkwMzk4MTc2LCJleHAiOjE2OTAzOTk5NzYsImVtYWlsIjoiZW1haWxAZW1haWwuY29tIn0.DD3H9blgJM8fwDEe1buE1QGNPde2eTalwpVpHULyjXS1Nyu_kc7D8l1eBZZJ3lERoH6mu8HCy_XnUWvxkBuSQfM66n54xqfHIHl8yeY6LWoHEYDtEY6JQuSN8qVOYsH3ekTzMB44cpVab3B4GIR3-xwMJmQ46tlhxetvnw95p2Gdtp77VvAhRrIjTqp4eEh5s3e2KvtAdtSnDWIPrANMyFV59sbEPa1jL_sGPzcV7MZTL9jbbeVStLpoSvO7cvpCRXv-A4Bfv7nfFsDM-LYR4QF2RRidvDVPN6PZ-wSbvBCCwZuUA1dErXr6n9_LgEuj_wU49GJEzYk3zTrc1zbOZw

    private final AccessTokenManager accessTokenManager;
    private final RefreshTokenManager refreshTokenManager;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestBody LoginPayload payload) {
        User user = User.builder().email("email@email.com").build();
        user.setId(1L);

        return BaseResponse.success(
                LoginResponse.builder()
                        .accessToken(accessTokenManager.generate(user))
                        .refreshToken(refreshTokenManager.generate(
                                RefreshTokenDto.builder().user(user).rememberMe(payload.isRememberMe()).build()
                        ))
                        .build()
        );
    }

    /*

    1. step: request (access token) -> access token expired
    2. step: refresh token -> acc token refresh token
    3. step: request (new access token) -> success

    */


}
