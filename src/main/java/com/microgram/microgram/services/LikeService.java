package com.microgram.microgram.services;

import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import com.microgram.microgram.repositories.LikeRepositories;
import com.microgram.microgram.repositories.PostRepositories;
import com.microgram.microgram.repositories.UserRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikeService {
    LikeRepositories likeRepositories;
    PostRepositories postRepositories;
    UserRepositories userRepositories;

    public boolean isThereAnyLikeByUserAndPost(Integer postId, String userEmail) {
        Optional<Post> post = postRepositories.findById(postId);
        User user = userRepositories.findByEmail(userEmail);
        return likeRepositories.existsByPostAndAndUser(post, user);
    }
}
