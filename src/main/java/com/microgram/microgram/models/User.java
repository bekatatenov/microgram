package com.microgram.microgram.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Integer id;
    @Column
    private String login;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private Integer countOfPosts;
    @Column
    private Integer countOfFollowers;
    @Column
    private Integer countOfSubs;
}
