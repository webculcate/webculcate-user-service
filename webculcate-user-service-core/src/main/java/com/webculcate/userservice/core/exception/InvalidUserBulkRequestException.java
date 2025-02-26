package com.webculcate.userservice.core.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class InvalidUserBulkRequestException extends RuntimeException {

    private List<String> messageList;

    public InvalidUserBulkRequestException(List<String> errorMessageList) {
        this.messageList = errorMessageList;
    }
}
