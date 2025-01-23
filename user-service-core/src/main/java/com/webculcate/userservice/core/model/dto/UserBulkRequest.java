package com.webculcate.userservice.core.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBulkRequest {
    // TODO validation
    private Set<String> userIdSet;

}
