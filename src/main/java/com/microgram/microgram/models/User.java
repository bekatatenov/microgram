package com.microgram.microgram.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String login;
    private String email;
    private String name;
    private String password;
    private Integer countOfPosts = 0;
    private Integer countOfFollowers = 0;
    private Integer countOfSubs = 0;

    public User(String login, String email, String name, String password) {
        id = UUID.randomUUID().toString();
        this.login = login;
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
