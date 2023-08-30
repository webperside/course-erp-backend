package com.webperside.courseerpbackend.exception;

import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.enums.response.ResponseMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler  {

//    extends ResponseEntityExceptionHandler

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse<?>> handleBaseException(BaseException ex) {
        return ResponseEntity.status(ex.getResponseMessage().status()).body(BaseResponse.error(ex));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<BaseResponse<?>> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        BaseException baseException = (BaseException) ex.getCause();
        return ResponseEntity.status(baseException.getResponseMessage().status()).body(BaseResponse.error(baseException));
    }

}
