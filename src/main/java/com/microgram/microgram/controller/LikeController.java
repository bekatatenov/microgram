package com.microgram.microgram.controller;

import com.microgram.microgram.dto.LikeDto;
import com.microgram.microgram.models.Like;
import com.microgram.microgram.models.User;
import com.microgram.microgram.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping("/{postId}")
    public LikeDto addLike(@PathVariable String postId, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return likeService.addLike(postId, user.getId());
    }

    @DeleteMapping("{likeId}")
    public ResponseEntity<Void> deleteLike(@PathVariable String likeId, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Like like = likeService.findById(likeId);
        if (like.getPost().getUser().getId().equals(user) || like.getUser().getId().equals(user.getId())) {
            if (likeService.deleteLike(likeId))
                return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}