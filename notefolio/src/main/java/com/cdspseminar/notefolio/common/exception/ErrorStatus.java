package com.cdspseminar.notefolio.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum ErrorStatus {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "리소스 접근 권한이 없습니다."),
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "대상을 찾을 수 없습니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "잘못된 HTTP method 요청입니다."),
    CONFLICT(HttpStatus.CONFLICT, "이미 존재하는 리소스입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다."),
    PROGRAMS_NOT_FOUND(HttpStatus.NOT_FOUND, "프로그램이 없습니다."),
    CREATIVE_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 크리에이티브입니다."),
    CREATOR_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 크리에이터입니다."),
    HEART_NOT_FOUND(HttpStatus.NOT_FOUND, "좋아요하지 않은 크리에이티브입니다.") //추후 수정 예정...
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
