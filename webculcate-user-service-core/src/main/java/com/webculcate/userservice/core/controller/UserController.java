package com.webculcate.userservice.core.controller;

import com.webculcate.userservice.core.model.dto.general.*;
import com.webculcate.userservice.core.model.dto.user.UserDto;
import com.webculcate.userservice.core.service.IUserService;
import com.webculcate.userservice.core.service.UserServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceManager userServiceManager;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        IUserService userService = userServiceManager.getUserService();
        return new ResponseEntity<>(userService.getUser(id), OK);
    }

    @PostMapping("/bulk")
    public ResponseEntity<UserBulkResponse> getUserBulk(@RequestBody UserBulkRequest request) {
        IUserService userService = userServiceManager.getUserService();
        return new ResponseEntity<>(userService.getUserBulk(request), OK);
    }

    @PostMapping
    public ResponseEntity<UserCreationResponse> createNewUser(@RequestBody UserCreationRequest request) {
        IUserService userService = userServiceManager.getUserService();
        return new ResponseEntity<>(userService.createUser(request), OK);
    }

    @PutMapping
    public ResponseEntity<UserUpdateResponse> updateUser(@RequestBody UserUpdateRequest request) {
        IUserService userService = userServiceManager.getUserService();
        return new ResponseEntity<>(userService.updateUser(request), OK);
    }

}
