package com.microgram.microgram.services;

import com.microgram.microgram.dto.PostDto;
import com.microgram.microgram.exception.ResourceNotFoundException;
import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.PostImage;
import com.microgram.microgram.models.Subscription;
import com.microgram.microgram.models.User;
import com.microgram.microgram.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    SubscriptionRepositories subscriptionRepositories;
    PostRepositories postRepositories;
    UserRepositories userRepositories;
    LikeRepositories likeRepositories;
    CommentRepositories commentRepositories;
    PostImageRepositories postImageRepositories;
    PostImageService postImageService;

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

    public Post findById(String id) {
        return postRepositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("There is no such post"));
    }

    public List<PostDto> findPostsOfUser(String id) {
        User user = userRepositories.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is no such a user with " + id + " id"));
        List<Post> allByUserId = postRepositories.findAllByUserId(id);
        List<PostDto> posts = new ArrayList<>();
        for (Post p :
                allByUserId) {
            posts.add(PostDto.from(p));
        }
        return posts;
    }

    public PostDto addPost(String text, String userId, MultipartFile file) {
        User user = userRepositories.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no such a user with " + userId + " id"));

        PostImage postImage = postImageService.addImage(file);
        Post post = new Post(postImage, text, LocalDate.now(), user);
        postRepositories.save(post);
        return PostDto.from(post);
    }

    public boolean deletePost(String postId) {
        Post postById = postRepositories.findPostById(postId);
        likeRepositories.deleteLikesByPostId(postId);
        commentRepositories.deleteCommentsByPostId(postId);
        postRepositories.deleteById(postId);
        postImageRepositories.deleteById(postById.getPostImage().getId());
        return true;
    }
}
