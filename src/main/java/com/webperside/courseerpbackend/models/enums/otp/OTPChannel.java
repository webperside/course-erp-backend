package com.webperside.courseerpbackend.models.enums.otp;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.exception.ExceptionBuilder;
import com.webperside.courseerpbackend.models.mybatis.user.User;

public enum OTPChannel {
    SMS, EMAIL;

    public String getTarget(User user) {
        if (this.equals(SMS)) {
            return user.getPhoneNumber();
        } else if (this.equals(EMAIL)) {
            return user.getEmail();
        } else {
            throw ExceptionBuilder.unexpected();
        }
    }
}
