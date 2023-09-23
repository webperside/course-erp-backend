package com.webperside.courseerpbackend.models.mybatis.base;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity<ID> extends IsDeletedEntity<ID> {

    ID id;

}