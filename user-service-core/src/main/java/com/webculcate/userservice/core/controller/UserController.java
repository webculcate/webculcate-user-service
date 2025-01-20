package com.webculcate.userservice.core.controller;

import com.webculcate.userservice.core.model.dto.UserCreationRequest;
import com.webculcate.userservice.core.model.dto.UserCreationResponse;
import com.webculcate.userservice.core.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user/v1")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserCreationResponse> createNewUser(@RequestBody UserCreationRequest request) {
        return new ResponseEntity<>(userService.createUser(request), OK);
    }

}
