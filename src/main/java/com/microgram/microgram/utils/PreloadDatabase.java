//package com.microgram.microgram.utils;
//
//import com.microgram.microgram.models.Comment;
//import com.microgram.microgram.models.Like;
//import com.microgram.microgram.models.User;
//import com.microgram.microgram.repositories.*;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Stream;
//
//@Configuration
//
//public class PreloadDatabase {
//    @Bean
//    CommandLineRunner initDatabase(CommentRepositories commentRepositories,
//                                   LikeRepositories likeRepositories,
//                                   PostRepositories postRepositories,
//                                   SubscriptionRepositories subscriptionRepositories,
//                                   UserRepositories userRepositories) {
//        return (args) -> {
//
//            commentRepositories.deleteAll();
//
//
//            userRepositories.deleteAll();
//
//            List<User> users = new ArrayList<>();
//            users.add(User.builder()
//                    .id(1)
//                    .userName("Test1")
//                    .email("test1@gmmail.com")
//                    .password("test1password")
//                    .build()
//            );
//
//            List<User> myUs = userRepositories.findAll();
//            users.add(User.builder()
//                    .id(2)
//                    .userName("Test2")
//                    .email("test2@gmmail.com")
//                    .password("test2password")
//                    .myUsers(myUs)
//                    .build()
//            );
//
//            List<User> all = userRepositories.findAll();
//            users.add(User.builder()
//                    .id(3)
//                    .userName("Test3")
//                    .email("test3@gmmail.com")
//                    .password("test3password")
//                    .myUsers(all)
//                    .meUsers(myUs)
//                    .build()
//            );
//            userRepositories.saveAll(users);
//
//            postRepositories.deleteAll();
//
//
//            List<Comment> comments = new ArrayList<>();
//            comments.add(Comment.builder()
//                    .id(1)
//                    .text("test1")
//                    .dateOfComment(LocalDate.now())
//                    .build()
//            );
//            comments.add(Comment.builder()
//                    .id(2)
//                    .text("test2")
//                    .dateOfComment(LocalDate.now())
//                    .build()
//            );
//            comments.add(Comment.builder()
//                    .id(3)
//                    .text("test3")
//                    .dateOfComment(LocalDate.now())
//                    .build()
//            );
//            commentRepositories.saveAll(comments);
//
//            // Error creating bean
//            //
//        };
//    }
//}
//
