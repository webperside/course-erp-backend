package com.webperside.courseerpbackend.utils;

import com.webperside.courseerpbackend.exception.OTPValidationException;
import com.webperside.courseerpbackend.models.enums.otp.OTPValidationResult;
import com.webperside.courseerpbackend.services.redis.RedisService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OTPUtilsTest {

    @Mock
    private RedisService mockRedisService;

    @InjectMocks
    private OTPUtils otpUtils;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        otpUtils.setRedisService(mockRedisService);

    }

    @Test
    public void testGenerate() {

        String generatedOTP = otpUtils.generate();
        assertNotNull(generatedOTP);
        assertTrue(generatedOTP.matches("\\d{4}"));

    }

    @Test
    public void testIsValidWithValidOTP() {
        String key = "valid_key";
        String otp = "1234";

        Mockito.when(mockRedisService.get(key)).thenReturn("1234");

        try {
            otpUtils.isValid(key, otp);
        } catch (OTPValidationException e) {
            fail("Validation should pass for a valid OTP");
        }
    }

    @Test
    public void testIsValidWithInvalidOTP() {
        String key = "invalid_key";
        String otp = "5678";

        Mockito.when(mockRedisService.get(key)).thenReturn("1234");

        try {
            otpUtils.isValid(key, otp);
            fail("Validation should fail for an invalid OTP");
        } catch (OTPValidationException e) {
            assertEquals(OTPValidationResult.OTP_IS_NOT_VALID, e.getCause());
        }
    }
}
