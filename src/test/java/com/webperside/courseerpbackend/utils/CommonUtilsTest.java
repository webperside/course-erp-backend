package com.webperside.courseerpbackend.utils;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.exception.ExceptionBuilder;
import org.junit.jupiter.api.Test;

import static com.webperside.courseerpbackend.utils.CommonUtils.Checker;
import static com.webperside.courseerpbackend.utils.CommonUtils.throwIf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommonUtilsTest {

    @Test
    public void testThrowIfConditionSucceeds() {

        Checker checker = () -> false;

        throwIf(checker, ExceptionBuilder.unexpected());

    }

    @Test
    public void testThrowIfConditionFails() {

        Checker checker = () -> true;

        assertThrows(BaseException.class, () -> throwIf(checker, ExceptionBuilder.unexpected()));

    }

}

