package com.webculcate.userservice.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactInfoRequest {
    // TODO validation
    private String email;

}
