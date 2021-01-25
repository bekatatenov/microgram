package com.microgram.microgram.controller;

import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import com.microgram.microgram.services.LikeService;
import com.microgram.microgram.services.PostService;
import com.microgram.microgram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    LikeService likeService;
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @GetMapping("/find/user/name")
    public List<User> findUsersByName(@RequestParam("name") String name) {
        return userService.findUserByName(name);
    }

    @GetMapping("/find/user/login")
    public User findUserByLogin(@RequestParam("login") String login) {
        return userService.findUserByLogin(login);
    }

    @GetMapping("/find/user/email")
    public User findUserByEmail(@RequestParam("email") String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/check/user/email")
    public boolean isThereAnyUserByEmail(@RequestParam("email") String email) {
        return userService.IsThereAnyUserByEmail(email);
    }

    @GetMapping("/posts/others")
    public List<Post> allOthersPosts(@RequestParam("userId") Integer id) {
        return postService.findAllOthersPost(id);
    }

    @GetMapping("/posts/myflw")
    public List<Post> allPostsByMyFlw(@RequestParam("userId") Integer id) {
        return postService.findAllMySubPosts(id);
    }

    @GetMapping("/like")
    public boolean isThereAnyLike(@RequestParam("postId") Integer postId, @RequestParam("userId") Integer userId) {
        return likeService.isThereAnyLikeByUserAndPost(userId, postId);
    }
}