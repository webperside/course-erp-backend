package com.webperside.courseerpbackend.services.otp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailOTPServiceImpl implements OTPService{
    @Override
    public void send() {
        log.info("OTP sent: {}", UUID.randomUUID());
    }
}
