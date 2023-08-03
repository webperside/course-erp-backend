package com.webperside.courseerpbackend.exception;

import com.webperside.courseerpbackend.exception.types.NotFoundExceptionType;
import com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages;
import com.webperside.courseerpbackend.models.enums.response.ResponseMessages;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.NOT_FOUND;
import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.UNEXPECTED;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseException extends RuntimeException {

    ResponseMessages responseMessage;
    NotFoundExceptionType notFoundData;

    // todo: fix. it doesn't return dynamic error message
    @Override
    public String getMessage() {
        return responseMessage.message();
    }

    public static BaseException unexpected() {
        return BaseException.builder().responseMessage(UNEXPECTED).build();
    }

    public static BaseException notFound(String target, String field, String value) {
        return BaseException.builder()
                .responseMessage(NOT_FOUND)
                .notFoundData(
                        NotFoundExceptionType.of(target, Map.of(field, value))
                )
                .build();
    }

}
