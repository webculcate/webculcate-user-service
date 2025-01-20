package com.webculcate.userservice.core.model.dto;

import lombok.Data;

@Data
public class UserNameRequest {
    // TODO validation

    private String displayName;

    private String firstName;

    private String middleName;

    private String lastName;

}
