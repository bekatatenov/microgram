package com.microgram.microgram.utils;

import com.microgram.microgram.models.Comment;
import com.microgram.microgram.models.Like;
import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import com.microgram.microgram.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration

public class PreloadDatabase {
    @Bean
    CommandLineRunner initDatabase(CommentRepositories commentRepositories,
                                   LikeRepositories likeRepositories,
                                   PostRepositories postRepositories,
                                   SubscriptionRepositories subscriptionRepositories,
                                   UserRepositories userRepositories) {
        return (args) -> {
            likeRepositories.deleteAll();
            commentRepositories.deleteAll();
            subscriptionRepositories.deleteAll();
            postRepositories.deleteAll();
            userRepositories.deleteAll();

            List<User> users = new ArrayList<>();
            users.add(User.builder()
                    .id(1)
                    .login("Test1")
                    .email("test1@gmmail.com")
                    .password("test1password")
                    .build()
            );
            users.add(User.builder()
                    .id(2)
                    .login("Test2")
                    .email("test2@gmmail.com")
                    .password("test2password")
                    .build()
            );
            users.add(User.builder()
                    .id(3)
                    .login("Test3")
                    .email("test3@gmmail.com")
                    .password("test3password")
                    .build()
            );
            userRepositories.saveAll(users);

            List<Post> posts = getPosts(users);

            postRepositories.saveAll(posts);

            List<Comment> comments = getComments(posts, users);
            commentRepositories.saveAll(comments);

            List<Like> likes = getLikes(users, posts);
            likeRepositories.saveAll(likes);
        };
    }

    private List<Like> getLikes(List<User> users, List<Post> posts) {
        List<Like> likes = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < posts.size(); i++) {
            for (int j = 0; j < users.size(); j++) {
                count++;
                likes.add(new Like(count, users.get(j), posts.get(i), LocalDate.now()));
            }
        }
        return likes;
    }

    private List<Comment> getComments(List<Post> posts, List<User> users) {
        List<Comment> comments = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < posts.size(); i++) {
            for (int j = 0; j < users.size(); j++) {
                count++;
                comments.add(new Comment(count, posts.get(i),
                        Generator.makeDescription(), LocalDate.now(), users.get(j)));
            }
        }
        return comments;
    }

    private List<Post> getPosts(List<User> users) {
        List<Post> posts = new ArrayList<>();
        Random rnd = new Random();
        int coutn = 1;
        for (int i = 1; i <= users.size(); i++) {
            for (int j = 0; j < rnd.nextInt(5) + 1; j++) {
                posts.add(new Post(coutn, "images/1pic.jpg", Generator.makeDescription(), LocalDate.now(), users.get(i - 1)));
                coutn++;
            }
        }
        return posts;
    }
}

