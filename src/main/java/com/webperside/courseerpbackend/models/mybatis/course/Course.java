package com.webperside.courseerpbackend.models.mybatis.course;

import com.webperside.courseerpbackend.models.enums.course.CourseStatus;
import com.webperside.courseerpbackend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course extends BaseEntity {

    String name;
    CourseStatus status;

}
