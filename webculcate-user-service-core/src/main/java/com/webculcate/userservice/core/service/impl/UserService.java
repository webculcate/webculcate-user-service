package com.webculcate.userservice.core.service.impl;

import com.webculcate.userservice.core.exception.UserNotAvailableException;
import com.webculcate.userservice.core.model.dto.general.*;
import com.webculcate.userservice.core.model.dto.user.UserDto;
import com.webculcate.userservice.core.model.entity.User;
import com.webculcate.userservice.core.service.IUserDtoMapper;
import com.webculcate.userservice.core.service.IUserService;
import com.webculcate.userservice.core.service.factory.IUserFactory;
import com.webculcate.userservice.core.service.transaction.UserTransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.webculcate.userservice.core.constant.ServiceExceptionType.USER_NOT_AVAILABLE;
import static com.webculcate.userservice.core.constant.UserServiceStrategyType.DEFAULT_SERVICE;
import static java.util.Objects.nonNull;


@Slf4j
@Service(DEFAULT_SERVICE)
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserTransactionService userTransactionService;

    private final IUserFactory userFactory;

    private final IUserDtoMapper userDtoMapper;

    @Override
    public UserDto getUser(Long id) {
        Optional<User> optionalUser = userTransactionService.fetchUser(id);
        User fetchedUser = optionalUser
                .orElseThrow(() -> new UserNotAvailableException(USER_NOT_AVAILABLE.getMessage()));
        log.info("User fetched");
        return userDtoMapper.mapToUserDto(fetchedUser);
    }

    @Override
    public UserBulkResponse getUserBulk(UserBulkRequest request) {
        Set<Long> userIdSet = request.getUserIdSet();
        UserBulkResponse response = new UserBulkResponse();
        if (!userIdSet.isEmpty()) {
            List<User> fetchedUsers = userTransactionService.fetchUsers(userIdSet);
            if(nonNull(fetchedUsers)) {
                log.info("{} users fetched", fetchedUsers.size());
                List<UserDto> userDtoList = fetchedUsers.stream()
                        .map(userDtoMapper::mapToUserDto)
                        .toList();
                response.setUserList(userDtoList);
            }
        }
        return response;
    }

    @Override
    public UserCreationResponse createUser(UserCreationRequest request) {
        User newUser = userFactory.generateUser(request);
        User savedUser = userTransactionService.saveUser(newUser);
        log.info("User created");
        return new UserCreationResponse(userDtoMapper.mapToUserDto(savedUser));
    }

    @Override
    public UserUpdateResponse updateUser(UserUpdateRequest request) {
        User updatedUser = userFactory.generateUser(request);
        User savedUser = userTransactionService.fetchAndUpdateUser(request.getUserId(), updatedUser);
        log.info("User updated");
        return new UserUpdateResponse(userDtoMapper.mapToUserDto(savedUser));
    }

}
