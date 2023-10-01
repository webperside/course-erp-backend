package com.webperside.courseerpbackend.services.security;

import com.webperside.courseerpbackend.models.common.proceedkey.ProceedKey;
import com.webperside.courseerpbackend.models.payload.auth.LoginPayload;
import com.webperside.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.webperside.courseerpbackend.models.payload.auth.signup.SignUpPayload;
import com.webperside.courseerpbackend.models.payload.auth.signup.SignUpOTPChannelRequest;
import com.webperside.courseerpbackend.models.payload.auth.signup.SignUpOTPRequest;
import com.webperside.courseerpbackend.models.response.auth.LoginResponse;

public interface AuthBusinessService {

    LoginResponse login(LoginPayload payload);

    LoginResponse refresh(RefreshTokenPayload payload);

    void logout();

    ProceedKey signUp(SignUpPayload payload);

    void signUpOTP(SignUpOTPChannelRequest payload);

    void signUpOTPConfirmation(SignUpOTPRequest payload);

    void setAuthentication(String email);

}
