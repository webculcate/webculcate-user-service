package com.webculcate.userservice.core.service;

import com.webculcate.userservice.core.model.dto.general.UserUpdateRequest;
import com.webculcate.userservice.core.model.dto.general.UserUpdateResponse;
import com.webculcate.userservice.core.model.dto.general.UserBulkRequest;
import com.webculcate.userservice.core.model.dto.general.UserBulkResponse;
import com.webculcate.userservice.core.model.dto.general.UserCreationResponse;
import com.webculcate.userservice.core.model.dto.general.UserCreationRequest;
import com.webculcate.userservice.core.model.dto.user.UserDto;

public interface IUserService {

    UserDto getUser(Long id);

    UserBulkResponse getUserBulk(UserBulkRequest request);

    UserCreationResponse createUser(UserCreationRequest request);

    UserUpdateResponse updateUser(UserUpdateRequest request);
}
