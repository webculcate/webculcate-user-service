package com.webculcate.userservice.core.model.entity.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class FullName {

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    private String lastName;
}
