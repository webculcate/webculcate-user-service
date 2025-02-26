package com.webculcate.userservice.core.model.entity.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class UserName {

    @Column(unique = true, nullable = false)
    private String displayName;

    @Embedded
    private FullName fullName;
}
