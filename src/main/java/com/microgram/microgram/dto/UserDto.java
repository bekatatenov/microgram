package com.microgram.microgram.dto;


import com.microgram.microgram.models.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class UserDto {
    private String id;
    private String login;
    private String email;
    private String name;
    private String password;
    private Integer countOfPosts;
    private Integer countOfFollowers;
    private Integer countOfSubs;

    public static UserDto from(User user) {
        return builder()
                .id(user.getId())
                .login(user.getLogin())
                .email(user.getEmail())
                .name(user.getName())
                .countOfPosts(user.getCountOfPosts())
                .countOfFollowers(user.getCountOfFollowers())
                .countOfSubs(user.getCountOfSubs())
                .build();
    }
}
