package com.webperside.courseerpbackend.helpers;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.exception.ExceptionBuilder;
import com.webperside.courseerpbackend.services.redis.RedisService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.OTP_IS_NOT_VALID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class OTPHelperTest {

    private RedisService mockRedisService;

    // under test
    private OTPHelper otpHelper;

    @BeforeEach
    public void setUp() {
        mockRedisService = mock(RedisService.class);
        this.otpHelper = new OTPHelper(this.mockRedisService);
    }

    @Test
    public void testGenerate() {

        String generatedOTP = otpHelper.generate();
        assertNotNull(generatedOTP);
        assertTrue(generatedOTP.matches("\\d{4}"));
    }

    @Test
    public void testIsValidWithValidOTP() {

        String key = "valid_key";
        String otp = "1234";

        Mockito.when(mockRedisService.get(key)).thenReturn("1234");

        try {
            otpHelper.isValid(key, otp);
        } catch (Exception e) {
            fail("Validation should pass for a valid OTP");
        }

    }

    @Test
    public void testIsValidWithInvalidOTP() {

        String key = "invalid_key";
        String otp = "5678";

        Mockito.when(mockRedisService.get(key)).thenReturn("1234");

        try {
            otpHelper.isValid(key, otp);
            fail("Validation should fail for an invalid OTP");
        } catch (Exception e) {
            assertEquals(ExceptionBuilder.of(OTP_IS_NOT_VALID).getMessage(), e.getMessage());
        }

    }
}
