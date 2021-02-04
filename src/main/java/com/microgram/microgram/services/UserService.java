package com.microgram.microgram.services;

import com.microgram.microgram.dto.PostDto;
import com.microgram.microgram.dto.UserDto;
import com.microgram.microgram.exception.ThereIsSuchResourceFoundException;
import com.microgram.microgram.models.User;
import com.microgram.microgram.repositories.UserRepositories;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {
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
        return UserDto.from(userRepositories.findByEmail(email).get());
    }

    public boolean IsThereAnyUserByEmail(String email) {
        return userRepositories.existsByEmail(email);
    }

    public boolean isThereAnyUserByLogin(String login) {
        return userRepositories.existsByLogin(login);
    }

    public UserDto addUser(User userData) {

//        if (IsThereAnyUserByEmail(userData.getEmail())) {
//            throw new ThereIsSuchResourceFoundException("There is a User with this email " + userData.getEmail());
//        }
//        if (isThereAnyUserByLogin(userData.getLogin())) {
//            throw new ThereIsSuchResourceFoundException(("There is a User with this login" + userData.getLogin()));
//        }
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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return (UserDetails) userRepositories.findByEmail(s)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("user with email %s not found", s)));
    }
}