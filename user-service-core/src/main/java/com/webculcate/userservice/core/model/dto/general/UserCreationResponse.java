package com.webculcate.userservice.core.model.dto.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webculcate.userservice.core.model.dto.user.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.webculcate.userservice.core.constant.APIMetadata.USER_CREATION;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class UserCreationResponse {

    private String message;

    private UserDto user;

    public UserCreationResponse(String message, UserDto user) {
        this.message = message;
        this.user = user;
    }

    public UserCreationResponse(UserDto user) {
        this.user = user;
        this.message = USER_CREATION.getSuccessMessage();
    }
}
