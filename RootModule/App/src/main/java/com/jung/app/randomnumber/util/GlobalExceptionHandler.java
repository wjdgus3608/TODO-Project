package com.jung.app.randomnumber.util;

import com.jung.domain.error.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jung.domain.error.ResponseTemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseTemplate> handleCustomException(CustomException e) {
        log.error("CustomException : {}",e.getResponseCode());
        return ResponseTemplate.toResponseEntity(e.getResponseCode());
    }

    @ExceptionHandler(Exception.class)
    public Exception ExceptionAdvice(Exception e) {
        log.error("JustException : {}",e);
        return e;
    }
}
