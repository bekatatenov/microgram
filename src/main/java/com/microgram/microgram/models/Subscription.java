package com.microgram.microgram.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;


@Document(collection = "subs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subscription {
    @Id
    private String id;
    @DBRef
    private User user;
    @DBRef
    private User toUser;
    private LocalDate date;

    public Subscription(User user, User toUser, LocalDate date) {
        id = UUID.randomUUID().toString();
        this.id = id;
        this.user = user;
        this.toUser = toUser;
        this.date = date;
    }
}
