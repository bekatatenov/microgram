package com.microgram.microgram.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Integer id;
    private String login;
    private String email;
    private String password;
    private Integer countOfPosts;
    private Integer countOfFollowers;
    private Integer countOfSubs;
}
