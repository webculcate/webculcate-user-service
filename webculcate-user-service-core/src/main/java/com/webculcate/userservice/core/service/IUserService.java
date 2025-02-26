package com.webculcate.userservice.core.service;

import com.webculcate.userservice.core.model.dto.general.*;
import com.webculcate.userservice.core.model.dto.user.UserDto;

public interface IUserService {

    UserDto getUser(Long id);

    UserBulkResponse getUserBulk(UserBulkRequest request);

    UserCreationResponse createUser(UserCreationRequest request);

    UserUpdateResponse updateUser(UserUpdateRequest request);
}
