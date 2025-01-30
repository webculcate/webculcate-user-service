package com.webculcate.userservice.core.service.impl;

import com.webculcate.userservice.core.exception.UserNotAvailableException;
import com.webculcate.userservice.core.model.dto.general.UserUpdateRequest;
import com.webculcate.userservice.core.model.dto.general.UserUpdateResponse;
import com.webculcate.userservice.core.model.dto.general.UserBulkRequest;
import com.webculcate.userservice.core.model.dto.general.UserBulkResponse;
import com.webculcate.userservice.core.model.dto.user.UserDto;
import com.webculcate.userservice.core.model.entity.User;
import com.webculcate.userservice.core.model.dto.general.UserCreationRequest;
import com.webculcate.userservice.core.model.dto.general.UserCreationResponse;
import com.webculcate.userservice.core.repository.UserRepository;
import com.webculcate.userservice.core.service.IUserService;
import com.webculcate.userservice.core.service.IUserDtoMapper;
import com.webculcate.userservice.core.service.factory.IUserFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.webculcate.userservice.core.constant.ServiceExceptionType.USER_NOT_AVAILABLE;
import static com.webculcate.userservice.core.constant.UserServiceStrategyType.DEFAULT_SERVICE;


@Slf4j
@Service(DEFAULT_SERVICE)
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository repository;

    private final IUserFactory userFactory;

    private final IUserDtoMapper userDtoMapper;

    @Override
    public UserDto getUser(Long id) {
        Optional<User> optionalUser = fetchUser(id);
        User fetchedUser = optionalUser
                .orElseThrow(() -> new UserNotAvailableException(USER_NOT_AVAILABLE.getMessage()));
        return userDtoMapper.mapToUserDto(fetchedUser);
    }

    @Transactional
    private Optional<User> fetchUser(Long id) {
        return repository.findByUserId(id);
    }

    @Override
    public UserBulkResponse getUserBulk(UserBulkRequest request) {
        Set<String> userIdSet = request.getUserIdSet();
        UserBulkResponse response = new UserBulkResponse();
        if (!userIdSet.isEmpty()) {
            List<User> fetchedUsers = fetchUsers(userIdSet);
            List<UserDto> userDtoList = fetchedUsers.stream()
                    .map(userDtoMapper::mapToUserDto)
                    .toList();
            response.setUserList(userDtoList);
        }
        return response;
    }

    @Transactional
    private List<User> fetchUsers(Set<String> userIdSet) {
        return repository.findAllByUserIdIn(userIdSet);
    }

    @Override
    public UserCreationResponse createUser(UserCreationRequest request) {
        User newUser = userFactory.generateUser(request);
        User savedUser = saveUser(newUser);
        return new UserCreationResponse(userDtoMapper.mapToUserDto(savedUser));
    }

    @Transactional
    private User saveUser(User newUser) {
        return repository.save(newUser);
    }

    @Override
    public UserUpdateResponse updateUser(UserUpdateRequest request) {
        User updatedUser = userFactory.generateUser(request);
        User savedUser = fetchAndUpdateUser(request.getUserId(), updatedUser);
        return new UserUpdateResponse(userDtoMapper.mapToUserDto(savedUser));
    }

    @Transactional
    private User fetchAndUpdateUser(Long userId, User updatedUser) {
        Optional<User> optionalUser = fetchUser(userId);
        User fetchedUser = optionalUser
                .orElseThrow(() -> new UserNotAvailableException(USER_NOT_AVAILABLE.getMessage()));
        fetchedUser.setContactInfo(updatedUser.getContactInfo());
        fetchedUser.setUserName(updatedUser.getUserName());
        User savedUser = saveUser(fetchedUser);
        return savedUser;
    }
}
