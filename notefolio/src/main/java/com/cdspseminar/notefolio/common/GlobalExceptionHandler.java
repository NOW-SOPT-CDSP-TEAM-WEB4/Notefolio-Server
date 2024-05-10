package com.cdspseminar.notefolio.common;

import com.cdspseminar.notefolio.common.exception.BusinessException;
import com.cdspseminar.notefolio.common.exception.ErrorStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<?>> handleBusinessException(BusinessException e) {
        log.error(">>> handle: BusinessException ", e);
        return ApiResponse.error(e.errorStatus);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception e) {
        log.error(">>> handle: Exception ", e);
        return ApiResponse.error(ErrorStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(">>> handle: Exception ", Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        return ApiResponse.error(ErrorStatus.BAD_REQUEST);
    }
}
