package com.webculcate.userservice.core.service.proxy;

import com.webculcate.userservice.core.exception.InvalidUserCreationRequestException;
import com.webculcate.userservice.core.exception.UserIdCountExceededException;
import com.webculcate.userservice.core.model.dto.general.UserUpdateRequest;
import com.webculcate.userservice.core.model.dto.general.UserUpdateResponse;
import com.webculcate.userservice.core.model.dto.general.UserBulkRequest;
import com.webculcate.userservice.core.model.dto.general.UserBulkResponse;
import com.webculcate.userservice.core.model.dto.general.UserCreationRequest;
import com.webculcate.userservice.core.model.dto.general.UserCreationResponse;
import com.webculcate.userservice.core.model.dto.user.UserDto;
import com.webculcate.userservice.core.service.IUserService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.webculcate.userservice.core.constant.ServiceConstant.STRING_SPACE;
import static com.webculcate.userservice.core.constant.UserServiceStrategyType.PROXY;

@Slf4j
@Lazy
@Service(PROXY)
@RequiredArgsConstructor
public class UserServiceProxy implements IUserService {

    private final Validator serviceValidator;

    private final IUserService userService;

    @Value("${application.bulk.request.user.limit}")
    private Integer userIdCount = 10;

    @Override
    public UserDto getUser(Long id) {
        return userService.getUser(id);
    }

    @Override
    public UserBulkResponse getUserBulk(UserBulkRequest request) {
        serviceValidator.validate(request);
        if (request.getUserIdSet().size() > userIdCount)
            throw new UserIdCountExceededException(List.of("Please restrict the userId count to : " + userIdCount));
        else
            return userService.getUserBulk(request);
    }

    @Override
    public UserCreationResponse createUser(UserCreationRequest request) {
        Set<ConstraintViolation<UserCreationRequest>> validationResults = serviceValidator.validate(request);
        if (!validationResults.isEmpty()) {
            List<String> errorMessageList = validationResults.stream()
                    .map(result -> result.getPropertyPath() + STRING_SPACE + result.getMessage())
                    .toList();
            throw new InvalidUserCreationRequestException(errorMessageList);
        }
        return userService.createUser(request);
    }

    @Override
    public UserUpdateResponse updateUser(UserUpdateRequest request) {
        return userService.updateUser(request);
    }

}
