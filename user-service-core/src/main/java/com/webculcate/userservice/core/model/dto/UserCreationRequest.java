package com.webculcate.userservice.core.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreationRequest {

    @NotNull
    private UserNameRequest userNameRequest;

    @NotNull
    private ContactInfoRequest contactInfoRequest;
}
