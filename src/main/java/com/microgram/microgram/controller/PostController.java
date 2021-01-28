package com.microgram.microgram.controller;

import com.microgram.microgram.dto.PostDto;
import com.microgram.microgram.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostDto addPost(@RequestBody PostDto postData) {
        return postService.addPost(postData, postData.getUser().getId());
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePostById(@PathVariable String postId) {
        if (postService.deletePost(postId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}