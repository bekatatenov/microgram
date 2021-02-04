package com.microgram.microgram.utils;

import com.microgram.microgram.models.*;
import com.microgram.microgram.repositories.*;
import org.bson.types.Binary;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
                                   UserRepositories userRepositories,
                                   PostImageRepositories postImageRepositories) {
        return (args) -> {
            likeRepositories.deleteAll();
            commentRepositories.deleteAll();
            subscriptionRepositories.deleteAll();
            postRepositories.deleteAll();
            userRepositories.deleteAll();
            postImageRepositories.deleteAll();

            List<User> users = new ArrayList<>();
            users.add(User.builder()
                    .name("David")
                    .login("test1")
                    .email("test1@gmmail.com")
                    .password(new BCryptPasswordEncoder().encode("test1"))
                    .build()
            );
            users.add(User.builder()
                    .name("Anako")
                    .login("test2")
                    .email("test2@gmmail.com")
                    .password(new BCryptPasswordEncoder().encode("test2"))
                    .build()
            );
            users.add(User.builder()
                    .name("beks")
                    .login("test3")
                    .email("test3@gmmail.com")
                    .password(new BCryptPasswordEncoder().encode("test3"))
                    .build()
            );
            users.add(User.builder()
                    .name("John")
                    .login("test4")
                    .email("test4@gmmail.com")
                    .password(new BCryptPasswordEncoder().encode("test4"))
                    .build()
            );
            users.add(User.builder()
                    .name("Biden")
                    .login("test5")
                    .email("test5@gmmail.com")
                    .password(new BCryptPasswordEncoder().encode("test5"))
                    .build()
            );

            userRepositories.saveAll(users);

            List<Subscription> subs = getSubs(users);
            subscriptionRepositories.saveAll(subs);
            List<PostImage> postImages = getImages();
            postImageRepositories.saveAll(postImages);
            List<Post> posts = getPosts(users, postImages);
            postRepositories.saveAll(posts);
            List<Comment> comments = getComments(posts, users);
            commentRepositories.saveAll(comments);

            List<Like> likes = getLikes(users, posts);
            likeRepositories.saveAll(likes);
            users.add(User.builder()
                    .name("olol")
                    .login("test6")
                    .email("test6@gmmail.com")
                    .password(new BCryptPasswordEncoder().encode("test6"))
                    .build()
            );
            users.add(User.builder()
                    .name("mololo")
                    .login("test7")
                    .email("test7@gmmail.com")
                    .password(new BCryptPasswordEncoder().encode("test1"))
                    .build()
            );
            userRepositories.saveAll(users);
        };
    }

    private List<Subscription> getSubs(List<User> users) {

        List<Subscription> subscriptions = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            for (User user : users) {
                if (users.get(i) != user) {
                    subscriptions.add(new Subscription(users.get(i), user, LocalDate.now()));
                }
            }
        }
        return subscriptions;
    }

    private List<Like> getLikes(List<User> users, List<Post> posts) {
        List<Like> likes = new ArrayList<>();
        for (Post post : posts) {
            for (User user : users) {
                likes.add(new Like(user, post, LocalDate.now()));
            }
        }
        return likes;
    }

    private List<Comment> getComments(List<Post> posts, List<User> users) {
        List<Comment> comments = new ArrayList<>();
        for (Post post : posts) {
            for (User user : users) {
                comments.add(new Comment(post,
                        Generator.makeDescription(), LocalDate.now(), user));
            }
        }
        return comments;
    }

    private List<Post> getPosts(List<User> users, List<PostImage> postImages) {
        List<Post> posts = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 1; i <= users.size(); i++) {
            for (int j = 0; j < rnd.nextInt(5) + 1; j++) {
                posts.add(new Post(postImages.get(rnd.nextInt(3)), Generator.makeDescription(), LocalDate.now(), users.get(i - 1)));
            }
        }
        return posts;
    }

    private List<PostImage> getImages() throws IOException {
        List<PostImage> postImages = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String path = "src/main/resources/static/images/" + i + ".jpeg";
            File file = new File(path);
            byte[] bytes = Files.readAllBytes(file.toPath());
            Binary bData = new Binary(bytes);
            postImages.add(PostImage.builder().id(String.valueOf(i)).postData(bData).build());
        }
        return postImages;
    }
}