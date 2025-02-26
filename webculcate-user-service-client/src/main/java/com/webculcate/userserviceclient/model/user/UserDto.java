package com.webculcate.userserviceclient.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long userId;

    private UserNameDto userName;

    private ContactInfoDto contactInfo;

    private TimeLogDto timeLog;

    public static UserDto initializeBlankUserDto() {
        return UserDto.builder()
                .contactInfo(new ContactInfoDto())
                .timeLog(new TimeLogDto())
                .userName(UserNameDto.builder()
                        .fullName(new FullNameDto())
                        .build())
                .build();
    }
}
