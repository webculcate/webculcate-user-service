package com.webculcate.userservice.core.service.factory;

import com.webculcate.userservice.core.model.entity.User;
import com.webculcate.userservice.core.model.dto.UserCreationRequest;
import org.springframework.stereotype.Service;

public interface IUserFactory {

    public User generateUser(UserCreationRequest request);
}
