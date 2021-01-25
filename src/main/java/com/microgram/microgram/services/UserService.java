package com.microgram.microgram.services;

import com.microgram.microgram.models.User;
import com.microgram.microgram.repositories.UserRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepositories userRepositories;

    public List<User> findUserByName(String name) {
        return userRepositories.findByName(name);
    }

    public User findUserByLogin(String login) {
        return userRepositories.findByLogin(login);
    }

    public User findUserByEmail(String email) {
        return userRepositories.findByEmail(email);
    }

    public boolean IsThereAnyUserByEmail(String email) {
        return userRepositories.existsByEmail(email);
    }
}
