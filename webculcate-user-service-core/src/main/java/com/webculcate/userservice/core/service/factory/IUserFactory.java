package com.webculcate.userservice.core.service.factory;

import com.webculcate.userservice.core.model.dto.general.UserCreationRequest;
import com.webculcate.userservice.core.model.entity.User;

public interface IUserFactory {

    User generateUser(UserCreationRequest request);
}
