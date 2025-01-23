package com.webculcate.userservice.core.model.entity;

import com.webculcate.userservice.core.model.entity.embedded.ContactInfo;
import com.webculcate.userservice.core.model.entity.embedded.TimeLog;
import com.webculcate.userservice.core.model.entity.embedded.UserName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.webculcate.userservice.core.constant.ServiceConstant.USER_SEQUENCE_NAME;
import static com.webculcate.userservice.core.constant.ServiceConstant.USER_TABLE_NAME;

@Data
@Builder
@Entity
@Table(name = USER_TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @SequenceGenerator(
            name = USER_SEQUENCE_NAME,
            sequenceName = USER_SEQUENCE_NAME,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = USER_SEQUENCE_NAME
    )
    private Long userId;

    @Embedded
    private UserName userName;

    @Embedded
    private ContactInfo contactInfo;

    @Embedded
    private TimeLog timeLog;

    @Version
    private Long version;

}
