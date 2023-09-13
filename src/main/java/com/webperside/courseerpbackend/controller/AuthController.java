package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.payload.auth.LoginPayload;
import com.webperside.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.webperside.courseerpbackend.models.payload.auth.SignUpPayload;
import com.webperside.courseerpbackend.models.payload.otp.BaseOTPChannelRequest;
import com.webperside.courseerpbackend.models.payload.otp.BaseOTPRequest;
import com.webperside.courseerpbackend.models.response.auth.LoginResponse;
import com.webperside.courseerpbackend.services.security.AuthBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthBusinessService authBusinessService;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestBody LoginPayload payload) {
        return BaseResponse.success(authBusinessService.login(payload));
    }

    @PostMapping("/token/refresh")
    public BaseResponse<LoginResponse> refresh(@RequestBody RefreshTokenPayload payload) {
        return BaseResponse.success(authBusinessService.refresh(payload));
    }

    @PostMapping("/logout")
    public BaseResponse<Void> logout() {
        authBusinessService.logout();
        return BaseResponse.success();
    }

    @PostMapping("/sign-up")
    public BaseResponse<Void> signUp(@RequestBody SignUpPayload payload) {
        authBusinessService.signUp(payload);
        // return proceedKey for continuing sign up process
        return BaseResponse.success();
    }

    // use proceedKey
    @PostMapping("/sign-up/otp/request")
    public BaseResponse<Void> otpRequest(@RequestBody BaseOTPChannelRequest payload) {
        authBusinessService.signUpOTP(payload);
        return BaseResponse.success();
    }

    @PostMapping("/sign-up/otp/confirmation")
    public BaseResponse<Void> otpConfirmation(@RequestBody BaseOTPRequest payload) {
        authBusinessService.signUpOTPConfirmation(payload);
        return BaseResponse.success();
    }

}
