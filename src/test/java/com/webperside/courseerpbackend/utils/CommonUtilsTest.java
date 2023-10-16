package com.webperside.courseerpbackend.utils;

import com.webperside.courseerpbackend.exception.BaseException;
import org.junit.jupiter.api.Test;

import static com.webperside.courseerpbackend.utils.CommonUtils.Checker;
import static com.webperside.courseerpbackend.utils.CommonUtils.throwIf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommonUtilsTest {

    @Test
    public void testThrowIfConditionSucceeds() {

        Checker checker = () -> false;

        throwIf(checker, BaseException.unexpected());

    }

    @Test
    public void testThrowIfConditionFails() {

        Checker checker = () -> true;

        assertThrows(BaseException.class, () -> throwIf(checker, BaseException.unexpected()));

    }

}

