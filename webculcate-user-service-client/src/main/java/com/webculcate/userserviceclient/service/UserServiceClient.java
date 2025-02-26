package com.webculcate.userserviceclient.service;

import com.webculcate.userserviceclient.model.UserBulkRequest;
import com.webculcate.userserviceclient.model.UserBulkResponse;
import com.webculcate.userserviceclient.model.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.webculcate.userserviceclient.constant.UserServiceConstant.WEBCULCATE_USER_SERVICE;

@FeignClient(name = WEBCULCATE_USER_SERVICE)
public interface UserServiceClient {

    @GetMapping("/user/v1/{id}")
    ResponseEntity<UserDto> getUser(@PathVariable("id") Long id);

    @PostMapping("/user/v1/bulk")
    ResponseEntity<UserBulkResponse> getUserBulk(@RequestBody UserBulkRequest request);

}
