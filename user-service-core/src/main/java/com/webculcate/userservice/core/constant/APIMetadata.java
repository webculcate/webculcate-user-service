package com.webculcate.userservice.core.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum APIMetadata {

    USER_CREATION("User creation successful", "User creation failed");

    private final String successMessage;

    private final String failureMessage;

}
