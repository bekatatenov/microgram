package com.microgram.microgram.controller;

import com.microgram.microgram.dto.PostDto;
import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import com.microgram.microgram.repositories.UserRepositories;
import com.microgram.microgram.services.PostService;
import com.microgram.microgram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    UserRepositories userRepositories;

    @PostMapping()
    public ResponseEntity addPost(@RequestParam("desc") String desc, @RequestParam("image") MultipartFile image) {
        try {
//            User user = (User) authentication.getPrincipal();
            User user = new User("jsTest", "js@test.com", "js", "js");
            userRepositories.save(user);
            postService.addPost(desc, user.getId(), image);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePostById(@PathVariable String postId, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Post byId = postService.findById(postId);
        if (byId.getUser().getId().equals(user.getId())) {
            if (postService.deletePost(postId)) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{userId}")
    public List<PostDto> allPostsOfUser(@PathVariable String userId) {
        return postService.findPostsOfUser(userId);
    }
}