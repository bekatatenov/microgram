package com.microgram.microgram.controller;

import com.microgram.microgram.dto.LikeDto;
import com.microgram.microgram.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping("/{postId}")
    public LikeDto addLike(@PathVariable String postId, @RequestParam("userId") String userId) {
        return likeService.addLike(postId, userId);
    }

    @DeleteMapping("{likeId}")
    public ResponseEntity<Void> deleteLike(@PathVariable String likeId) {
        if (likeService.deleteLike(likeId))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }
}