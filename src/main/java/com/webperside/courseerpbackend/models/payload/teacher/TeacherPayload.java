package com.webperside.courseerpbackend.models.payload.teacher;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherPayload {
    //todo: validation
    String name;
    String surname;
    String email;
    String phoneNumber;
}
