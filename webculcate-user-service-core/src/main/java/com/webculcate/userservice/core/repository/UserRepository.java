package com.webculcate.userservice.core.repository;

import com.webculcate.userservice.core.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(Long userId);

    List<User> findAllByUserIdIn(Set<Long> userIdSet);
}
