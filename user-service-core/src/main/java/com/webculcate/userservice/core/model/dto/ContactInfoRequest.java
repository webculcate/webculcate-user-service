package com.webculcate.userservice.core.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactInfoRequest {
//  TODO DEBUG
    @Valid
    @NotNull(groups = {UserCreationRequest.class})
    @NotEmpty(groups = {UserCreationRequest.class})
    private String email;

}
