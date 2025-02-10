package com.webculcate.userservice.core.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class InvalidUserCreationRequestException extends RuntimeException {

    private List<String> messageList;

    public InvalidUserCreationRequestException(List<String> messageList) {
        this.messageList = messageList;
    }

    public InvalidUserCreationRequestException(String message) {
        super(message);
    }

}
