package com.webperside.courseerpbackend.utils;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.services.redis.RedisService;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.OTP_IS_NOT_VALID;

@Component
public class OTPUtils {

    private static RedisService redisService;

    public OTPUtils(RedisService redisService) {
        this.redisService = redisService;
    }

    public static String generate() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }


    public static void isValid(String key, String otp) {

        String storedOtp = redisService.get(key);

        if (storedOtp == null || !storedOtp.equals(otp)) {
            throw BaseException.of(OTP_IS_NOT_VALID);
        }

    }

}