package com.webperside.courseerpbackend.helpers;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.services.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.OTP_IS_NOT_VALID;

@Component
@RequiredArgsConstructor
public class OTPHelper {

    private final RedisService redisService;

    public String generate() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    public void isValid(String key, String otp) {

        String storedOtp = redisService.get(key);

        if (storedOtp == null || !storedOtp.equals(otp)) {
            throw BaseException.of(OTP_IS_NOT_VALID);
        }

    }

}