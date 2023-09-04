package com.webperside.courseerpbackend.models.mybatis.subject;

import com.webperside.courseerpbackend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subject extends BaseEntity {

    String name;
    Long courseId;
    Long languageId;
}
