package com.webperside.courseerpbackend.utils;

import com.webperside.courseerpbackend.exception.OTPValidationException;
import com.webperside.courseerpbackend.models.enums.otp.OTPValidationResult;
import com.webperside.courseerpbackend.services.redis.RedisService;
import org.springframework.stereotype.Component;

import java.util.Random;

public class OTPUtils {

    private static RedisService redisService;

    public static void setRedisService(RedisService service){
        redisService=service;
    }

    public static String generate() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    public static void isValid(String key, String otp) {

        String storedOtp = redisService.get(key);

        if (storedOtp == null || !storedOtp.equals(otp)) {
            throw new OTPValidationException(OTPValidationResult.OTP_IS_NOT_VALID);
        }

    }

}