package com.webculcate.userservice.core.service.factory.impl;

import com.webculcate.userservice.core.model.entity.User;
import com.webculcate.userservice.core.model.entity.embedded.ContactInfo;
import com.webculcate.userservice.core.model.entity.embedded.FullName;
import com.webculcate.userservice.core.model.entity.embedded.UserName;
import com.webculcate.userservice.core.model.dto.ContactInfoRequest;
import com.webculcate.userservice.core.model.dto.UserCreationRequest;
import com.webculcate.userservice.core.model.dto.UserNameRequest;
import com.webculcate.userservice.core.service.factory.IUserFactory;
import org.springframework.stereotype.Service;

import static com.webculcate.userservice.core.utility.ServiceHelper.createTimeLog;
import static java.util.Objects.nonNull;

@Service
public class DefaultUserFactory implements IUserFactory {
    @Override
    public User generateUser(UserCreationRequest request) {
        // TODO validate request
        return User.builder()
                .userName(generateUserName(request.getUserNameRequest()))
                .contactInfo(generateContactInfo(request.getContactInfoRequest()))
                .timeLog(createTimeLog())
                .build();
    }

    private UserName generateUserName(UserNameRequest request) {
        if (nonNull(request))
            return new UserName(request.getDisplayName(), generateFullName(request));
        else
            return null;
    }

    private FullName generateFullName(UserNameRequest request) {
        if (nonNull(request))
            return new FullName(request.getFirstName(), request.getMiddleName(), request.getLastName());
        else
            return null;
    }

    private ContactInfo generateContactInfo(ContactInfoRequest request) {
        return nonNull(request) ? new ContactInfo(request.getEmail()) : null;
    }
}
