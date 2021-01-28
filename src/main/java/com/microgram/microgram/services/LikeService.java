package com.microgram.microgram.services;

import com.microgram.microgram.dto.CommentDto;
import com.microgram.microgram.dto.LikeDto;
import com.microgram.microgram.exception.ResourceNotFoundException;
import com.microgram.microgram.models.Comment;
import com.microgram.microgram.models.Like;
import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import com.microgram.microgram.repositories.LikeRepositories;
import com.microgram.microgram.repositories.PostRepositories;
import com.microgram.microgram.repositories.UserRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class LikeService {
    LikeRepositories likeRepositories;
    PostRepositories postRepositories;
    UserRepositories userRepositories;

    public boolean isThereAnyLikeByUserAndPost(String postId, String userId) {
        User userById = userRepositories.findUserById(userId);
        Post postById = postRepositories.findPostById(postId);
        return likeRepositories.existsLikeByUserAndPost(userById, postById);
    }

    public LikeDto addLike(String postId, String userId) {

        Post post = postRepositories.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("There is not such a post with " + postId + "id"));
        User user = userRepositories.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no such a user with " + userId + " id"));

        Like like = new Like(user, post, LocalDate.now());
        return LikeDto.from(like);
    }

    public boolean deleteLike(String likeId) {
        likeRepositories.deleteById(likeId);
        return true;
    }
}
