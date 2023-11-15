package com.webperside.courseerpbackend.models.mybatis.userConfig;


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
public class UserConfig extends BaseEntity<String> {
    String key;
    String value;
    Long entityId;
    Long userId;
}
