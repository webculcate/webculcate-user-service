package com.webculcate.userservice.core.model.dto.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webculcate.userservice.core.model.dto.user.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.webculcate.userservice.core.constant.APIMetadata.USER_MODIFICATION;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class UserUpdateResponse extends UserCreationResponse {

    public UserUpdateResponse(UserDto user) {
        super(USER_MODIFICATION.getSuccessMessage(), user);
    }

}
