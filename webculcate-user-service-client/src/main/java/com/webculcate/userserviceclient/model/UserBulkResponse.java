package com.webculcate.userserviceclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webculcate.userserviceclient.model.user.UserDto;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBulkResponse {

    private List<UserDto> userList;

}
