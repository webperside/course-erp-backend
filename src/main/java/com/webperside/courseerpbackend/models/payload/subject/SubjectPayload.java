package com.webperside.courseerpbackend.models.payload.subject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectPayload {
    String name;
    Long languageId;
}
