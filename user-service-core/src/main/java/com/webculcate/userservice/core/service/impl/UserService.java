package com.webculcate.userservice.core.service.impl;

import com.webculcate.userservice.core.model.entity.User;
import com.webculcate.userservice.core.model.dto.UserCreationRequest;
import com.webculcate.userservice.core.model.dto.UserCreationResponse;
import com.webculcate.userservice.core.repository.UserRepository;
import com.webculcate.userservice.core.service.IUserService;
import com.webculcate.userservice.core.service.factory.IUserFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository repository;

    private final IUserFactory userFactory;

    @Override
    public UserCreationResponse createUser(UserCreationRequest request) {
        User newUser = userFactory.generateUser(request);
        User savedUser = repository.save(newUser);
        return new UserCreationResponse(savedUser);
    }
}
