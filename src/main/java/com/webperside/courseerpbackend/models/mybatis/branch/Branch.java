package com.webperside.courseerpbackend.models.mybatis.branch;

import com.webperside.courseerpbackend.models.enums.branch.BranchStatus;
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
public class Branch extends BaseEntity {

    String name;
    BranchStatus status;
    String address;
    Double lat;
    Double lon;
    Long courseId;

}
