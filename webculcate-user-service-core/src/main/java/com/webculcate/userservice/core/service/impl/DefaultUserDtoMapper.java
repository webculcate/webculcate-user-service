package com.webculcate.userservice.core.service.impl;

import com.webculcate.userservice.core.model.dto.user.FullNameDto;
import com.webculcate.userservice.core.model.dto.user.UserDto;
import com.webculcate.userservice.core.model.entity.User;
import com.webculcate.userservice.core.model.entity.embedded.FullName;
import com.webculcate.userservice.core.service.IUserDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.webculcate.userservice.core.utility.ServiceHelper.nullHandledExtraction;
import static java.util.Objects.nonNull;
import static org.springframework.beans.BeanUtils.copyProperties;

@Slf4j
@Service
public class DefaultUserDtoMapper implements IUserDtoMapper {

    @Override
    public UserDto mapToUserDto(User fetchedUser) {
        UserDto userDto = UserDto.initializeBlankUserDto();
        copyProperties(fetchedUser, userDto);
        if (nonNull(fetchedUser.getContactInfo()) && nonNull(userDto.getContactInfo()))
            copyProperties(fetchedUser.getContactInfo(), userDto.getContactInfo());
        if (nonNull(fetchedUser.getTimeLog()) && nonNull(userDto.getTimeLog()))
            copyProperties(fetchedUser.getTimeLog(), userDto.getTimeLog());
        if (nonNull(fetchedUser.getUserName()) && nonNull(userDto.getUserName()))
            copyProperties(fetchedUser.getUserName(), userDto.getUserName());

        Optional<FullName> optionalFullName = nullHandledExtraction(() -> fetchedUser.getUserName().getFullName());
        Optional<FullNameDto> optionalFullNameDto = nullHandledExtraction(() -> userDto.getUserName().getFullName());

        if (optionalFullName.isPresent() && optionalFullNameDto.isPresent())
            copyProperties(optionalFullName.get(), optionalFullNameDto.get());

        return userDto;
    }

}
