package com.microgram.microgram.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    private Integer id;
    private String userName;
    private String email;
    private String password;
    private int countOfPosts;
    private List<User> myUsers;
    private List<User> meUsers;
}