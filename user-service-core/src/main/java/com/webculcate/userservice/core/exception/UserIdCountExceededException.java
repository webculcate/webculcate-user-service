package com.webculcate.userservice.core.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class UserIdCountExceededException extends RuntimeException {

    private List<String> messageList;

    public UserIdCountExceededException(List<String> messageList) {
        this.messageList = messageList;
    }

    public UserIdCountExceededException(String message) {
        super(message);
    }

}
