package com.webperside.courseerpbackend.services.otp;

import com.webperside.courseerpbackend.models.dto.SendOTPDto;
import com.webperside.courseerpbackend.services.redis.RedisService;
import com.webperside.courseerpbackend.utils.OTPUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailOTPServiceImpl implements OTPService{

    private final RedisService redisService;

    @Override
    public void send(SendOTPDto dto) {
        final String otp = OTPUtils.generate();

        redisService.set(dto.getKey(), otp, 5);

        log.info("OTP sent via Email to: {}, OTP: {}", dto.getTarget(), otp);
    }
}
