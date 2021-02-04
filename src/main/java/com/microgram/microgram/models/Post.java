package com.microgram.microgram.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Document(collection = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    private String id;

    @DBRef
    private PostImage postImage;
    private String text;
    private LocalDate date;
    @DBRef
    private User user;
    @DBRef
    private List<Like> likes;
    @DBRef
    private List<Comment> comments;

    public Post(PostImage postImage, String text, LocalDate date, User user) {
        id = UUID.randomUUID().toString();
        this.postImage = postImage;
        this.text = text;
        this.date = date;
        this.user = user;
    }
}
