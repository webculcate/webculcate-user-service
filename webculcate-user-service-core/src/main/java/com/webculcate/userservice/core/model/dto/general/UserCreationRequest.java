package com.webculcate.userservice.core.model.dto.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreationRequest {

    @Valid
    @NotNull
    private UserNameRequest userName;

    @Valid
    @NotNull
    private ContactInfoRequest contactInfo;

}
