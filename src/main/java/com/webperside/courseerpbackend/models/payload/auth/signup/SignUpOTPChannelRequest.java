package com.webperside.courseerpbackend.models.payload.auth.signup;

import com.webperside.courseerpbackend.models.common.proceedkey.ProceedKey;
import com.webperside.courseerpbackend.models.enums.otp.OTPChannel;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class SignUpOTPChannelRequest extends ProceedKey {

    private OTPChannel channel;

}
