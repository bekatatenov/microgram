package com.microgram.microgram.dto;


import com.microgram.microgram.models.Comment;
import com.microgram.microgram.models.Like;
import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class PostDto {
    private String id;
    private String postImageId;
    private String text;
    private LocalDate date;
    private User user;
    private List<Like> likes;
    private List<Comment> comments;

    public static PostDto from(Post post) {
        return builder()
                .id(post.getId())
                .postImageId(post.getPostImage().getId())
                .text(post.getText())
                .date(post.getDate())
                .user(post.getUser())
                .comments(post.getComments())
                .likes(post.getLikes())
                .build();
    }
}