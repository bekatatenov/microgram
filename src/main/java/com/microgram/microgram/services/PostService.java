package com.microgram.microgram.services;

import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.Subscription;
import com.microgram.microgram.repositories.PostRepositories;
import com.microgram.microgram.repositories.SubscriptionRepositories;
import com.microgram.microgram.repositories.UserRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    SubscriptionRepositories subscriptionRepositories;
    PostRepositories postRepositories;
    UserRepositories userRepositories;

    public List<Post> findAllMySubPosts(String id) {
        List<Subscription> allByUserId = subscriptionRepositories.findAllByUserId(id);
        List<Post> posts = new ArrayList<>();
        for (Subscription s :
                allByUserId) {
            List<Post> postsByUser = postRepositories.findAllByUserId(s.getToUser().getId());
            posts.addAll(postsByUser);
        }
        return posts;
    }
    public List<Post> findAllOthersPost(String id) {
        return postRepositories.findAllByUserId(id);
    }
}
