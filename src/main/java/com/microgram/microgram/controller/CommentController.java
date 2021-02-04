package com.microgram.microgram.controller;

import com.microgram.microgram.dto.CommentDto;
import com.microgram.microgram.exception.ResourceNotFoundException;
import com.microgram.microgram.models.Comment;
import com.microgram.microgram.models.User;
import com.microgram.microgram.services.CommentService;
import com.microgram.microgram.services.LikeService;
import com.microgram.microgram.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    LikeService likeService;

    @Autowired
    PostService postService;


    @PostMapping(path = "/{postId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommentDto addComment(@RequestBody CommentDto commentData,
                                 @PathVariable String postId,
                                 Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        boolean thereAnyLikeByUserAndPost = likeService.isThereAnyLikeByUserAndPost(postId, user.getId());
        if (!thereAnyLikeByUserAndPost) {
            throw new ResourceNotFoundException("There is no like in this post by user");
        }

        return commentService.addComment(commentData, postId, user.getId());
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deletePostById(@PathVariable String commentId,
                                               Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Comment comment = commentService.findById(commentId);
        if (comment.getPost().getUser().getId().equals(user.getId())) {
            if (commentService.deleteComment(commentId)) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
