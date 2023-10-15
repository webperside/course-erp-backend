package com.webperside.courseerpbackend.utils;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.services.redis.RedisService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.OTP_IS_NOT_VALID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OTPUtilsTest {

    @Mock
    private RedisService mockRedisService;

    private OTPUtils otpUtils;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        this.otpUtils = new OTPUtils(this.mockRedisService);

    }

    @Test
    public void testGenerate() {

        String generatedOTP = OTPUtils.generate();
        assertNotNull(generatedOTP);
        assertTrue(generatedOTP.matches("\\d{4}"));

    }

    @Test
    public void testIsValidWithValidOTP() {

        String key = "valid_key";
        String otp = "1234";

        Mockito.when(mockRedisService.get(key)).thenReturn("1234");

        try {
            OTPUtils.isValid(key, otp);
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
            OTPUtils.isValid(key, otp);
            fail("Validation should fail for an invalid OTP");
        } catch (Exception e) {
            assertEquals(BaseException.of(OTP_IS_NOT_VALID).getMessage(), e.getMessage());
        }

    }
}
