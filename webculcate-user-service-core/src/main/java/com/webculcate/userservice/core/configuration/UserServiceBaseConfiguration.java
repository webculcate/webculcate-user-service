package com.webculcate.userservice.core.configuration;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class UserServiceBaseConfiguration {

    @Bean
    public Validator createValidator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

}
