package com.webculcate.userservice.core.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webculcate.userservice.core.constant.ServiceExceptionType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceExceptionResponse {

    private ServiceExceptionType exceptionType;

    private String message;

    private List<Object> details;

}
