package com.webculcate.userservice.core.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class InvalidUserUpdateRequestException extends RuntimeException {

    private List<String> messageList;

    public InvalidUserUpdateRequestException(List<String> errorMessageList) {
        this.messageList = errorMessageList;
    }
}
