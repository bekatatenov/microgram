package com.microgram.microgram.services;

import com.microgram.microgram.dto.PostDto;
import com.microgram.microgram.dto.UserDto;
import com.microgram.microgram.models.User;
import com.microgram.microgram.repositories.UserRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepositories userRepositories;

    public List<UserDto> findUserByName(String name) {
        List<User> byName = userRepositories.findByName(name);
        List<UserDto> users = new ArrayList<>();
        for (User u :
                byName) {
            users.add(UserDto.from(u));
        }
        return users;
    }

    public UserDto findUserByLogin(String login) {
        return UserDto.from(userRepositories.findByLogin(login));
    }

    public UserDto findUserByEmail(String email) {
        return UserDto.from(userRepositories.findByEmail(email));
    }

    public boolean IsThereAnyUserByEmail(String email) {
        return userRepositories.existsByEmail(email);
    }

    public boolean isThereAnyUserByLogin(String login) {
        return userRepositories.existsByLogin(login);
    }

    public UserDto addUser(User userData) {
        User user = new User(userData.getLogin(), userData.getEmail(), userData.getName(), userData.getPassword());
        userRepositories.save(user);
        return UserDto.from(user);
    }

    public boolean deleteUser(String userId) {
        userRepositories.deleteById(userId);
        return true;
    }

    public UserDto findById(String id) {
        return UserDto.from(userRepositories.findUserById(id));
    }
}