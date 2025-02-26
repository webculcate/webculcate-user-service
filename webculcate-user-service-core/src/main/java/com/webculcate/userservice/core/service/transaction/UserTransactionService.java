package com.webculcate.userservice.core.service.transaction;

import com.webculcate.userservice.core.exception.UserNotAvailableException;
import com.webculcate.userservice.core.model.entity.User;
import com.webculcate.userservice.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.webculcate.userservice.core.constant.ServiceExceptionType.USER_NOT_AVAILABLE;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserTransactionService {

    private final UserRepository repository;

    @Transactional(readOnly = true)
    public Optional<User> fetchUser(Long id) {
        return repository.findByUserId(id);
    }

    @Transactional(readOnly = true)
    public List<User> fetchUsers(Set<Long> userIdSet) {
        return repository.findAllByUserIdIn(userIdSet);
    }

    @Transactional
    public User saveUser(User newUser) {
        return repository.save(newUser);
    }

    @Transactional
    public User fetchAndUpdateUser(Long userId, User updatedUser) {
        Optional<User> optionalUser = fetchUser(userId);
        User fetchedUser = optionalUser
                .orElseThrow(() -> new UserNotAvailableException(USER_NOT_AVAILABLE.getMessage()));
        fetchedUser.setContactInfo(updatedUser.getContactInfo());
        fetchedUser.setUserName(updatedUser.getUserName());
        User savedUser = saveUser(fetchedUser);
        return savedUser;
    }
}
