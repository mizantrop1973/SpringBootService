package com.java.service.transfer;

import com.java.service.models.User;
import lombok.Builder;
import lombok.Data;

//send user to page
@Builder
@Data
public class UserDto {
    private String firstName;
    private String lastName;

    public static UserDto from(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }


}
