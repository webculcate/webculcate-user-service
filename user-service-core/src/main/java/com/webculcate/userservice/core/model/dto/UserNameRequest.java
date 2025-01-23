package com.webculcate.userservice.core.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserNameRequest {

    @Valid
    @NotNull(groups = {UserCreationRequest.class})
    @NotEmpty(groups = {UserCreationRequest.class})
    private String displayName;

    @Valid
    @NotNull(groups = {UserCreationRequest.class})
    @NotEmpty(groups = {UserCreationRequest.class})
    private String firstName;

    private String middleName;

    private String lastName;

}
