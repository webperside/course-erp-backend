package com.webperside.courseerpbackend.services.security;

import com.webperside.courseerpbackend.models.payload.auth.LoginPayload;
import com.webperside.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.webperside.courseerpbackend.models.payload.auth.SignUpPayload;
import com.webperside.courseerpbackend.models.response.auth.LoginResponse;

public interface AuthBusinessService {

    LoginResponse login(LoginPayload payload);

    LoginResponse refresh(RefreshTokenPayload payload);

    void logout();

    void signUp(SignUpPayload payload);

    void setAuthentication(String email);

}
