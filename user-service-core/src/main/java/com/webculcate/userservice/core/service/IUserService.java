package com.webculcate.userservice.core.service;

import com.webculcate.userservice.core.model.UserUpdateRequest;
import com.webculcate.userservice.core.model.UserUpdateResponse;
import com.webculcate.userservice.core.model.dto.UserBulkRequest;
import com.webculcate.userservice.core.model.dto.UserBulkResponse;
import com.webculcate.userservice.core.model.dto.UserCreationResponse;
import com.webculcate.userservice.core.model.dto.UserCreationRequest;
import com.webculcate.userservice.core.model.dto.user.UserDto;

public interface IUserService {

    UserDto getUser(Long id);

    UserBulkResponse getUserBulk(UserBulkRequest request);

    UserCreationResponse createUser(UserCreationRequest request);

    UserUpdateResponse updateUser(UserUpdateRequest request);
}
