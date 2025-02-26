package com.webculcate.userservice.core.service.factory.impl;

import com.webculcate.userservice.core.model.dto.general.ContactInfoRequest;
import com.webculcate.userservice.core.model.dto.general.UserCreationRequest;
import com.webculcate.userservice.core.model.dto.general.UserNameRequest;
import com.webculcate.userservice.core.model.entity.User;
import com.webculcate.userservice.core.model.entity.embedded.ContactInfo;
import com.webculcate.userservice.core.model.entity.embedded.FullName;
import com.webculcate.userservice.core.model.entity.embedded.TimeLog;
import com.webculcate.userservice.core.model.entity.embedded.UserName;
import com.webculcate.userservice.core.service.factory.IUserFactory;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class DefaultUserFactory implements IUserFactory {
    @Override
    public User generateUser(UserCreationRequest request) {
        return User.builder()
                .userName(generateUserName(request.getUserName()))
                .contactInfo(generateContactInfo(request.getContactInfo()))
                .timeLog(new TimeLog())
                .build();
    }

    private UserName generateUserName(UserNameRequest request) {
        if (nonNull(request))
            return new UserName(request.getDisplayName(), generateFullName(request));
        else
            return new UserName();
    }

    private FullName generateFullName(UserNameRequest request) {
        if (nonNull(request))
            return new FullName(request.getFirstName(), request.getMiddleName(), request.getLastName());
        else
            return new FullName();
    }

    private ContactInfo generateContactInfo(ContactInfoRequest request) {
        return nonNull(request) ? new ContactInfo(request.getEmail()) : new ContactInfo();
    }
}
