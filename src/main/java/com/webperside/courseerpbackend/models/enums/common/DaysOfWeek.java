package com.webperside.courseerpbackend.models.enums.common;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DaysOfWeek {
    Sunday(0, "Sunday"),
    Monday(1, "Monday"),
    Tuesday(2, "Tuesday"),
    Wednesday(3, "Wednesday"),
    Thursday(4, "Thursday"),
    Friday(5, "Friday"),
    Saturday(6, "Saturday");

    private final int key;
    private final String value;
}
