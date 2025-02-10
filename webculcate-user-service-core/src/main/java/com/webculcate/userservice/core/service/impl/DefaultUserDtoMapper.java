package com.webculcate.userservice.core.service.impl;

import com.webculcate.userservice.core.model.dto.user.UserDto;
import com.webculcate.userservice.core.model.entity.User;
import com.webculcate.userservice.core.service.IUserDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Slf4j
@Service
public class DefaultUserDtoMapper implements IUserDtoMapper {

    @Override
    public UserDto mapToUserDto(User fetchedUser) {
        UserDto userDto = UserDto.initializeBlankUserDto();
        copyProperties(fetchedUser, userDto);
        copyProperties(fetchedUser.getContactInfo(), userDto.getContactInfo());
        copyProperties(fetchedUser.getTimeLog(), userDto.getTimeLog());
        copyProperties(fetchedUser.getUserName(), userDto.getUserName());
        copyProperties(fetchedUser.getUserName().getFullName(), userDto.getUserName().getFullName());
        return userDto;
    }

}
