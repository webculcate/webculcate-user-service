package com.webculcate.userservice.core.service.impl;

import com.webculcate.userservice.core.exception.UserNotAvailableException;
import com.webculcate.userservice.core.model.UserUpdateRequest;
import com.webculcate.userservice.core.model.UserUpdateResponse;
import com.webculcate.userservice.core.model.dto.UserBulkRequest;
import com.webculcate.userservice.core.model.dto.UserBulkResponse;
import com.webculcate.userservice.core.model.dto.user.UserDto;
import com.webculcate.userservice.core.model.entity.User;
import com.webculcate.userservice.core.model.dto.UserCreationRequest;
import com.webculcate.userservice.core.model.dto.UserCreationResponse;
import com.webculcate.userservice.core.repository.UserRepository;
import com.webculcate.userservice.core.service.IUserService;
import com.webculcate.userservice.core.service.IUserDtoMapper;
import com.webculcate.userservice.core.service.factory.IUserFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.webculcate.userservice.core.constant.ServiceExceptionType.USER_NOT_AVAILABLE;
import static com.webculcate.userservice.core.constant.UserServiceStrategyType.DEFAULT_SERVICE;
import static org.springframework.beans.BeanUtils.copyProperties;


@Slf4j
@Service(DEFAULT_SERVICE)
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository repository;

    private final IUserFactory userFactory;

    private final IUserDtoMapper userDtoMapper;

    @Override
    public UserDto getUser(Long id) {
        Optional<User> optionalUser = repository.findByUserId(id);
        User fetchedUser = optionalUser
                .orElseThrow(() -> new UserNotAvailableException(USER_NOT_AVAILABLE.getMessage()));
        return userDtoMapper.mapToUserDto(fetchedUser);
    }

    @Override
    public UserBulkResponse getUserBulk(UserBulkRequest request) {
        Set<String> userIdSet = request.getUserIdSet();
        UserBulkResponse response = new UserBulkResponse();
        if (!userIdSet.isEmpty()) {
            List<User> fetchedUsers = repository.findAllByUserId(userIdSet);
            List<UserDto> userDtoList = fetchedUsers.stream()
                    .map(userDtoMapper::mapToUserDto)
                    .toList();
            response.setUserList(userDtoList);
        }
        return response;
    }

    @Override
    public UserCreationResponse createUser(UserCreationRequest request) {
        User newUser = userFactory.generateUser(request);
        User savedUser = repository.save(newUser);
        return new UserCreationResponse(savedUser);
    }

    @Override
    public UserUpdateResponse updateUser(UserUpdateRequest request) {
        Optional<User> optionalUser = repository.findByUserId(request.getUserId());
        User fetchedUser = optionalUser
                .orElseThrow(() -> new UserNotAvailableException(USER_NOT_AVAILABLE.getMessage()));
        User updatedUser = userFactory.generateUser(request);
        fetchedUser.setContactInfo(updatedUser.getContactInfo());
        fetchedUser.setUserName(updatedUser.getUserName());
        fetchedUser.getTimeLog().setModificationTime(System.currentTimeMillis());
        User savedUser = repository.save(fetchedUser);
        return new UserUpdateResponse(savedUser);
    }
}
