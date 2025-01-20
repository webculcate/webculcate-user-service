package com.webculcate.userservice.core.service;

import com.webculcate.userservice.core.model.dto.UserCreationResponse;
import com.webculcate.userservice.core.model.dto.UserCreationRequest;

public interface IUserService {

    public UserCreationResponse createUser(UserCreationRequest request);

}
