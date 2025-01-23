package com.webculcate.userservice.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webculcate.userservice.core.model.dto.UserCreationRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class UserUpdateRequest extends UserCreationRequest {

    @NotNull
    @NotEmpty
    private Long userId;

}
