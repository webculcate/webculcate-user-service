package com.webculcate.userserviceclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBulkRequest {

    private Set<String> userIdSet;

}
