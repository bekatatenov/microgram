package com.microgram.microgram.controller;

import com.microgram.microgram.dto.PostDto;
import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import com.microgram.microgram.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostDto addPost(@RequestBody PostDto postData, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return postService.addPost(postData, user.getId());
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