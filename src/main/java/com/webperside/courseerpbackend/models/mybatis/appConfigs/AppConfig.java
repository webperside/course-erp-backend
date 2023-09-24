package com.webperside.courseerpbackend.models.mybatis.appConfigs;

import com.webperside.courseerpbackend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
<<<<<<< HEAD
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
=======

@Data
@Builder
>>>>>>> aff6fe5f3a790ea037fb3232dce391596a513f69
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfig extends BaseEntity<Long> {
    String value;
    String description;
}
