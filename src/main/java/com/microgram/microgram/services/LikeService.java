package com.microgram.microgram.services;

import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import com.microgram.microgram.repositories.LikeRepositories;
import com.microgram.microgram.repositories.PostRepositories;
import com.microgram.microgram.repositories.UserRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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
}
