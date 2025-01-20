package com.webculcate.userservice.core.constant;

import lombok.experimental.UtilityClass;

import static com.webculcate.userservice.core.constant.DatabaseConstant.USER;

@UtilityClass
public class ServiceConstant {

    // database

    public static final String USER_TABLE_NAME = "service_user";

    public static final String USER_SEQUENCE_NAME = USER_TABLE_NAME + "_sequence";

    // common

    public static final String EMPTY_STRING = "";
    public static final Long LONG_NUMBER_ZERO = 0L;
}
