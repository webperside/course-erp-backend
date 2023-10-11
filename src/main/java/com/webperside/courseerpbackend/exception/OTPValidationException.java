package com.webperside.courseerpbackend.exception;

import com.webperside.courseerpbackend.models.enums.otp.OTPValidationResult;

public class OTPValidationException extends RuntimeException {

    public OTPValidationException(OTPValidationResult otpValidationResult) {
    }
}
