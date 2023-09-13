package com.webperside.courseerpbackend.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectRequestDto {
    String name;
    Long languageId;
}
