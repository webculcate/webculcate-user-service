package com.webculcate.userservice.core.model.dto;

import lombok.Data;

@Data
public class UserCreationRequest {

    private UserNameRequest userNameRequest;

    private ContactInfoRequest contactInfoRequest;
}
