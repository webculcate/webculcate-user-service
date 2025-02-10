package com.webculcate.userservice.core.model.dto.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreationRequest {

    @NotNull
    private UserNameRequest userName;

    @NotNull
    private ContactInfoRequest contactInfo;

}
