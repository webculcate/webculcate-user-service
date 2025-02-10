package com.webculcate.userservice.core.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.webculcate.userservice.core.constant.ServiceConstant.USER_SEQUENCE_NAME;
import static com.webculcate.userservice.core.constant.ServiceConstant.USER_TABLE_NAME;

@Getter
@RequiredArgsConstructor
public enum DatabaseConstant {

    USER(USER_TABLE_NAME, DatabaseElement.TABLE),
    USER_SEQUENCE(USER_SEQUENCE_NAME, DatabaseElement.SEQUENCE);

    private final String displayName;
    private final DatabaseElement type;

}
