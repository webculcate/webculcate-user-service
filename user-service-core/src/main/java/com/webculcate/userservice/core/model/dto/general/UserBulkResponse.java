package com.webculcate.userservice.core.model.dto.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webculcate.userservice.core.model.dto.user.UserDto;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBulkResponse {
    // TODO validation
    private List<UserDto> userList;

}
