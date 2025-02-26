package com.webculcate.userservice.core.model.dto.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBulkRequest {

    @NotNull
    @NotEmpty
    private Set<Long> userIdSet;

}
