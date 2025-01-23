package com.webculcate.userservice.core.controller.exceptionhandler;

import com.webculcate.userservice.core.constant.ServiceExceptionType;
import com.webculcate.userservice.core.exception.InvalidUserCreationRequestException;
import com.webculcate.userservice.core.exception.UserIdCountExceededException;
import com.webculcate.userservice.core.exception.UserNotAvailableException;
import com.webculcate.userservice.core.model.dto.ServiceExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;

import static com.webculcate.userservice.core.constant.ServiceExceptionType.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(InvalidUserCreationRequestException.class)
    public ResponseEntity<ServiceExceptionResponse> handleUserCreationException(InvalidUserCreationRequestException exception) {
        return ResponseEntity.status(BAD_REQUEST)
                .body(new ServiceExceptionResponse(
                        INVALID_USER_CREATION_REQUEST,
                        INVALID_USER_CREATION_REQUEST.getMessage(),
                        List.of(exception.getMessageList()))
                );
    }

    @ExceptionHandler(UserIdCountExceededException.class)
    public ResponseEntity<ServiceExceptionResponse> handleUserIdCountExceededException(UserIdCountExceededException exception) {
        return ResponseEntity.status(BAD_REQUEST)
                .body(new ServiceExceptionResponse(
                        USER_ID_COUNT_EXCEEDED,
                        USER_ID_COUNT_EXCEEDED.getMessage(),
                        List.of(exception.getMessageList()))
                );
    }

    @ExceptionHandler(UserNotAvailableException.class)
    public ResponseEntity<ServiceExceptionResponse> handleUserNotAvailableException(UserNotAvailableException exception) {
        return ResponseEntity.status(NOT_FOUND)
                .body(new ServiceExceptionResponse(
                        USER_NOT_AVAILABLE,
                        USER_NOT_AVAILABLE.getMessage(),
                        Collections.emptyList())
                );
    }

}
