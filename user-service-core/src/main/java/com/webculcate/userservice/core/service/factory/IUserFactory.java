package com.webculcate.userservice.core.service.factory;

import com.webculcate.userservice.core.model.entity.User;
import com.webculcate.userservice.core.model.dto.general.UserCreationRequest;

public interface IUserFactory {

    User generateUser(UserCreationRequest request);
}
