package com.microgram.microgram.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "likes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Like {
    @Id
    private String id;
    @DBRef
    private User user;
    @DBRef
    private Post post;

    private LocalDate date;

    public Like(User user, Post post, LocalDate date) {
        id = UUID.randomUUID().toString();
        this.user = user;
        this.post = post;
        this.date = date;
    }
}
