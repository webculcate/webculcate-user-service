package com.webculcate.userservice.core.model.dto;

import com.webculcate.userservice.core.model.entity.User;
import lombok.Data;

import static com.webculcate.userservice.core.constant.APIMetadata.USER_CREATION;
import static com.webculcate.userservice.core.constant.ServiceConstant.*;
import static com.webculcate.userservice.core.utility.ServiceHelper.nullHandledExtraction;

@Data
public class UserCreationResponse {

    private String displayName;

    private Long creationTime;

    private String message;

    public UserCreationResponse(User user) {
        this.displayName = nullHandledExtraction(() -> user.getUserName().getDisplayName())
                .orElse(EMPTY_STRING);
        this.creationTime = nullHandledExtraction(() -> user.getTimeLog().getCreationTime())
                .orElse(LONG_NUMBER_ZERO);
        this.message = USER_CREATION.getSuccessMessage();
    }
}
