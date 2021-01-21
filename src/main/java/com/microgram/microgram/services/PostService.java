package com.microgram.microgram.services;

import com.microgram.microgram.models.Post;
import com.microgram.microgram.repositories.PostRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    PostRepositories postRepositories;

    public List<Post> getPosts() {
        // return all posts from db
        return postRepositories.findAll();
    }

    public void savePost(Post post) {
        postRepositories.save(post);
    }

    public void deletePost(Post post) {
        postRepositories.delete(post);
    }


    // and there will method that will change post
}
