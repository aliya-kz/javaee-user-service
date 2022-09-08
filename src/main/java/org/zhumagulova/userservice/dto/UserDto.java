package org.zhumagulova.userservice.dto;

import lombok.Data;
import org.zhumagulova.userservice.model.User;

@Data
public class UserDto {
    private String email;
    private String password;
    private long id;

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        return userDto;
    }

    public User user () {
        User user = new User();
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
}
