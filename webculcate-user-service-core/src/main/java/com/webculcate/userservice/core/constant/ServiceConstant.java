package com.webculcate.userservice.core.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ServiceConstant {

    // database

    public static final String USER_TABLE_NAME = "service_user";

    public static final String USER_SEQUENCE_NAME = USER_TABLE_NAME + "_sequence";

    public static final String DISPLAY_NAME_COLUMN = "display_name";

    public static final String DISPLAY_NAME_INDEX = DISPLAY_NAME_COLUMN + "_index";

    // common

    public static final String EMPTY_STRING = "";

    public static final String STRING_SPACE = " ";

    public static final Long LONG_NUMBER_ZERO = 0L;

    public static final String PROXY_ENABLED = "${application.proxy.enabled}";

}
