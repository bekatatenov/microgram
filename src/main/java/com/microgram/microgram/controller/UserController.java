package com.microgram.microgram.controller;

import com.microgram.microgram.dto.PostDto;
import com.microgram.microgram.dto.UserDto;
import com.microgram.microgram.exception.ThereIsSuchResourceFoundException;
import com.microgram.microgram.models.User;
import com.microgram.microgram.services.PostService;
import com.microgram.microgram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto addUser(@RequestBody User user) {
        if (userService.IsThereAnyUserByEmail(user.getEmail())) {
            throw new ThereIsSuchResourceFoundException("There is a User with this email " + user.getEmail());
        }
        if (userService.isThereAnyUserByLogin(user.getLogin())) {
            throw new ThereIsSuchResourceFoundException(("There is a User with this login" + user.getLogin()));
        }
        return userService.addUser(user);
    }

    @GetMapping("/findUserByName")
    public List<UserDto> findUsersByName(@RequestParam("name") String name) {
        return userService.findUserByName(name);
    }

    @GetMapping("/findUserByLogin")
    public UserDto findUserByLogin(@RequestParam("login") String login) {
        return userService.findUserByLogin(login);
    }

    @GetMapping("/findUserByEmail")
    public UserDto findUserByEmail(@RequestParam("email") String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/{userId}")
    public UserDto findUserById(@PathVariable String userId) {
        return userService.findById(userId);
    }

    @GetMapping("/{userId}/posts")
    public List<PostDto> allPostsOfUser(@PathVariable String userId) {
        return postService.findPostsOfUser(userId);
    }
}
