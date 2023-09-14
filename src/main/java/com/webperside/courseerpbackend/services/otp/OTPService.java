package com.webperside.courseerpbackend.services.otp;

import com.webperside.courseerpbackend.models.dto.SendOTPDto;

// Factory Pattern
public interface OTPService {

    void send(SendOTPDto dto);

}
