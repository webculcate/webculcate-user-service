package com.webculcate.userservice.core.model.dto.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserNameRequest {

    @NotNull
    @NotEmpty
    private String displayName;

    @NotNull
    @NotEmpty
    private String firstName;

    private String middleName;

    private String lastName;

}
