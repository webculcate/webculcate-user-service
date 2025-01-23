package com.webculcate.userservice.core.service;

import com.webculcate.userservice.core.model.dto.user.UserDto;
import com.webculcate.userservice.core.model.entity.User;

public interface IUserDtoMapper {

    UserDto mapToUserDto(User fetchedUser);

}
