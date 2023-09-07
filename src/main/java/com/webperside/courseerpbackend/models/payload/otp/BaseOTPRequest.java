package com.webperside.courseerpbackend.models.payload.otp;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseOTPRequest {

    private String otp;

}
