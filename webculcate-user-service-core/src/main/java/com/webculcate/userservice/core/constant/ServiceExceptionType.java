package com.webculcate.userservice.core.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ServiceExceptionType {

    INVALID_USER_CREATION_REQUEST("User creation request invalid"),
    USER_NOT_AVAILABLE("User not found"),
    USER_ID_COUNT_EXCEEDED("User id count exceeded");

    private final String message;
}
