package com.microgram.microgram.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;


@Document(collection = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    private String id;
    @DBRef
    private Post post;
    private String text;
    private LocalDate date;
    @DBRef
    private User user;

    public Comment(Post post, String text, LocalDate date, User user) {
        id = UUID.randomUUID().toString();
        this.post = post;
        this.text = text;
        this.date = date;
        this.user = user;
    }
}
