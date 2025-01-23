package com.webculcate.userservice.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webculcate.userservice.core.model.dto.UserCreationResponse;
import com.webculcate.userservice.core.model.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class UserUpdateResponse extends UserCreationResponse {

    public UserUpdateResponse(User user) {
        super(user);
    }

}
