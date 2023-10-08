package com.webperside.courseerpbackend.models.payload.auth.signup;

import com.webperside.courseerpbackend.models.common.proceedkey.ProceedKey;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class SignUpOTPRequest extends ProceedKey {

    private String otp;

}
