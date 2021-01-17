package com.microgram.microgram.models;

import lombok.Data;

import java.util.List;

@Data

public class User {
    private String userName;
    private String email;
    private String password;
    private int countOfPosts;
    private List<User> myUsers;
    private List<User> meUsers;
}
