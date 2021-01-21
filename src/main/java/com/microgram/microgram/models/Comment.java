package com.microgram.microgram.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    private Integer id;
    @DBRef
    private Post post;
    private String text;
    private LocalDate date;

    @DBRef
    private User user;
}
