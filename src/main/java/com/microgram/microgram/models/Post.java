package com.microgram.microgram.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    private Integer id;

    private String pathPicture;

    private String text;
    private LocalDate date;
    @DBRef
    private User user;
}
