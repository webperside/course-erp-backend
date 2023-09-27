package com.webperside.courseerpbackend.models.payload.group;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupPayload {
    String name;
}
