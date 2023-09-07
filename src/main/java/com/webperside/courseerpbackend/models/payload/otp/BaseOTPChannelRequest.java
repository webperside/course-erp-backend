package com.webperside.courseerpbackend.models.payload.otp;

import com.webperside.courseerpbackend.models.enums.otp.OTPChannel;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseOTPChannelRequest {

    private OTPChannel channel;

}
