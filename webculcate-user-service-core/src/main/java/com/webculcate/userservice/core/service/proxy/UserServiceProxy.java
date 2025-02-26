package com.webculcate.userservice.core.service.proxy;

import com.webculcate.userservice.core.exception.InvalidUserBulkRequestException;
import com.webculcate.userservice.core.exception.InvalidUserCreationRequestException;
import com.webculcate.userservice.core.exception.InvalidUserUpdateRequestException;
import com.webculcate.userservice.core.exception.UserIdCountExceededException;
import com.webculcate.userservice.core.model.dto.general.*;
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
        Set<ConstraintViolation<UserBulkRequest>> validationResults = serviceValidator.validate(request);
        if (!validationResults.isEmpty()) {
            List<String> errorMessageList = generateErrorMessageList(validationResults);
            throw new InvalidUserBulkRequestException(errorMessageList);
        }
        else if (request.getUserIdSet().size() > userIdCount)
            throw new UserIdCountExceededException(List.of("Please restrict the userId count to : " + userIdCount));
        else {
            log.info("Validation successful for getUserBulk");
            return userService.getUserBulk(request);
        }
    }

    @Override
    public UserCreationResponse createUser(UserCreationRequest request) {
        Set<ConstraintViolation<UserCreationRequest>> validationResults = serviceValidator.validate(request);
        if (!validationResults.isEmpty()) {
            List<String> errorMessageList = generateErrorMessageList(validationResults);
            throw new InvalidUserCreationRequestException(errorMessageList);
        }
        log.info("Validation successful for createUser");
        return userService.createUser(request);
    }

    @Override
    public UserUpdateResponse updateUser(UserUpdateRequest request) {
        Set<ConstraintViolation<UserUpdateRequest>> validationResults = serviceValidator.validate(request);
        if (!validationResults.isEmpty()) {
            List<String> errorMessageList = generateErrorMessageList(validationResults);
            throw new InvalidUserUpdateRequestException(errorMessageList);
        }
        log.info("Validation successful for updateUser");
        return userService.updateUser(request);
    }

    private <T> List<String> generateErrorMessageList(Set<ConstraintViolation<T>> validationResults) {
        return validationResults.stream()
                .map(result -> result.getPropertyPath() + STRING_SPACE + result.getMessage())
                .toList();
    }

}
